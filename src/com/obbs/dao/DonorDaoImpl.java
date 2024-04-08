package com.obbs.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.obbs.entity.BloodRequirementEntity;
import com.obbs.entity.DonorEntity;
import com.obbs.entity.FeedbackEntity;
import com.obbs.entity.SlotBookingEntity;
import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.FeedbackPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.SlotBookingPojo;

@Repository("donorDao")

public class DonorDaoImpl implements DonorDao {

	@Override // Donor register his/her details
	public int registerDonor(DonorPojo donorPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		try {
			// Here we Get Values from the Pojo and Set in entity fields.
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			long contactNumber;
			DonorEntity donorEntity = new DonorEntity();
			donorEntity.setDonorName(donorPojo.getDonorName());
			contactNumber = donorPojo.getContactNumber();
			donorEntity.setContactNumber(contactNumber);
			donorEntity.setState(donorPojo.getState());
			donorEntity.setArea(donorPojo.getArea());
			donorEntity.setPinCode(donorPojo.getPinCode());
			donorEntity.setBloodGroup(donorPojo.getBloodGroup());
			donorEntity.setEmail(donorPojo.getEmail());
			donorEntity.setPassword(donorPojo.getPassword());
			session.save(donorEntity);
			transaction.commit();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return 1;
	}

	@Override // Authentication of donor login
	public int donorLogin(DonorPojo donorPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		int id = 0;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			List list = session.createQuery("from DonorEntity").list();
			for (int i = 0; i < list.size(); i++) {
				DonorEntity donorEntity = (DonorEntity) list.get(i);
				if (donorPojo.getEmail().equals(donorEntity.getEmail())
						&& donorPojo.getPassword().equals(donorEntity.getPassword())) // Validating the Donor Login and
																						// Password with Database
																						// values.
				{
					donorPojo.setBloodGroup(donorEntity.getBloodGroup());
					donorPojo.setDonorName(donorEntity.getDonorName());
					donorPojo.setContactNumber(donorEntity.getContactNumber());
					id = donorEntity.getId();
				}
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return id;
	}

	@Override // Donor book the recipient at a particular slot
	public int confirmSlot(SlotBookingPojo slotBookingPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		SlotBookingEntity slotEntity = new SlotBookingEntity();
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			slotEntity.setRecipientId(slotBookingPojo.getRecipientId());
			slotEntity.setRecipientName(slotBookingPojo.getRecipientName());
			slotEntity.setDonorId(slotBookingPojo.getDonorId());
			slotEntity.setHospitalName(slotBookingPojo.getHospitalName());
			slotEntity.setArea(slotBookingPojo.getArea());
			slotEntity.setDate(slotBookingPojo.getDate());
			slotEntity.setTimeSlot(slotBookingPojo.getTimeSlot());
			slotEntity.setUserMailID(slotBookingPojo.getUserMailID());
			slotEntity.setDonorName(slotBookingPojo.getDonorName());
			slotEntity.setContactNumber(slotBookingPojo.getContactNumber());
			session.save(slotEntity);
			transaction.commit();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return slotEntity.getRecipientId();
	}

	@Override // After the slot is booked for recipient,the recipent's details will be deleted
				// from the blood requirement page
	public int deleteRequirement(int recipientId) throws ApplicationException {
		SessionFactory sessionfaFactory = null;
		Session session = null;
		try {
			sessionfaFactory = HibernateUtil.getSessionFactory();
			session = sessionfaFactory.openSession();
			Transaction transaction = session.beginTransaction();
			BloodRequirementEntity bloodRequirementEntity = new BloodRequirementEntity();
			bloodRequirementEntity.setId(recipientId);
			session.delete(bloodRequirementEntity);
			transaction.commit();

		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return 1;
	}

	@Override // donor give his/her feedback
	public int feedbackEntry(FeedbackPojo feedbackPojo) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		int feedback = 0;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			FeedbackEntity feedbackEntity = new FeedbackEntity();
			feedbackEntity.setId(feedbackPojo.getId());
			feedbackEntity.setName(feedbackPojo.getName());
			feedbackEntity.setHospitalName(feedbackPojo.getHospitalName());
			feedbackEntity.setCity(feedbackPojo.getCity());
			feedbackEntity.setFeedback(feedbackPojo.getFeedback());
			session.save(feedbackEntity);
			transaction.commit();
			feedback = 1;
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
		return feedback;
	}

	@Override // Fetching the feedback in the homepage
	public List feedbackFetch(FeedbackPojo feedbackPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		List<FeedbackPojo> details = null;
		details = new ArrayList<FeedbackPojo>();
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			List list = session.createQuery("from FeedbackEntity").list();
			for (int i = 0; i < list.size(); i++) {
				FeedbackEntity feedbackEntity = (FeedbackEntity) list.get(i);
				FeedbackPojo fPojo = new FeedbackPojo();
				fPojo.setId(feedbackEntity.getId());
				fPojo.setName(feedbackEntity.getName());
				fPojo.setHospitalName(feedbackEntity.getHospitalName());
				fPojo.setCity(feedbackEntity.getCity());
				fPojo.setFeedback(feedbackEntity.getFeedback());
				details.add(fPojo);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
		return details;
	}

	@Override
	// In this we Check the mail Id given by the user for new registration with
	// existing Mail Id's in database.
	public int mailCheckDonor(DonorPojo donorPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		int mailCheck = 0;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			List list = session.createQuery("from DonorEntity").list();
			for (int i = 0; i < list.size(); i++) {
				DonorEntity donorEntity = (DonorEntity) list.get(i);
				if (donorPojo.getEmail().equals(donorEntity.getEmail())) {
					mailCheck = 1;
				}
			}

		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return mailCheck;
	}

	@Override // Any viewer can view the blood requirements of recipients
	public List<PostBloodRequirementPojo> displayRequirements(String donorBloodGroup) throws ApplicationException {

		List<PostBloodRequirementPojo> displayList = null;
		List<PostBloodRequirementPojo> detailsList = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		List list = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.createQuery("from BloodRequirementEntity where blood_group=:bloodGroup");
			query.setParameter("bloodGroup", donorBloodGroup);
			displayList = new ArrayList();
			detailsList = new ArrayList();
			list = query.getResultList();
			detailsList = forLoop(list, displayList);

			System.out.println("out dao" + displayList);
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return detailsList; // This Returns the List as a Object
	}

	public List<PostBloodRequirementPojo> displayBloodCompatibility(String donorBloodGroup)
			throws ApplicationException {

		List<PostBloodRequirementPojo> displayList = null;
		List<PostBloodRequirementPojo> detailsList = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		System.out.println("hellooooo\n");
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			if (donorBloodGroup.equals("A +ve")) {

				List list = session.createQuery("from BloodRequirementEntity where blood_group like 'AB +ve'").list();
				displayList = new ArrayList();
				detailsList = new ArrayList();
				detailsList = forLoop(list, displayList);
			} else if (donorBloodGroup.equals("A -ve")) {
				List list = session.createQuery(
						"from BloodRequirementEntity where blood_group like 'A +ve'or blood_group like 'AB -ve' or blood_group like 'AB +ve'")
						.list();
				displayList = new ArrayList();
				detailsList = new ArrayList();
				detailsList = forLoop(list, displayList);
			} else if (donorBloodGroup.equals("B +ve")) {
				List list = session.createQuery("from BloodRequirementEntity where blood_group like 'AB +ve' ").list();
				displayList = new ArrayList();
				detailsList = new ArrayList();
				detailsList = forLoop(list, displayList);
			} else if (donorBloodGroup.equals("B -ve")) {
				List list = session.createQuery(
						"from BloodRequirementEntity where blood_group like 'B +ve'or blood_group like 'AB -ve' or blood_group like 'AB +ve'")
						.list();
				displayList = new ArrayList();
				detailsList = new ArrayList();
				detailsList = forLoop(list, displayList);
			}

			else if (donorBloodGroup.equals("AB -ve")) {
				List list = session.createQuery("from BloodRequirementEntity where blood_group like 'AB +ve'").list();
				displayList = new ArrayList();
				detailsList = new ArrayList();
				detailsList = forLoop(list, displayList);
			} else if (donorBloodGroup.equals("O +ve")) {
				List list = session.createQuery(
						"from BloodRequirementEntity where blood_group like 'A +ve'or blood_group like 'B +ve' or blood_group like 'AB +ve'")
						.list();
				displayList = new ArrayList();
				detailsList = new ArrayList();
				detailsList = forLoop(list, displayList);
			} else if (donorBloodGroup.equals("O -ve")) {
				List list = session.createQuery(
						"from BloodRequirementEntity where blood_group like 'A +ve' or blood_group like 'O +ve' or blood_group like 'B +ve' or blood_group like 'AB +ve' or blood_group like 'A -ve'or blood_group like 'B -ve' or blood_group like 'AB -ve' ")
						.list();
				displayList = new ArrayList();
				detailsList = new ArrayList();
				detailsList = forLoop(list, displayList);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return detailsList; // This Returns the List as a Object
	}

	public List<PostBloodRequirementPojo> forLoop(List list, List displayList) {
		for (int i = 0; i < list.size(); i++) // In this loop we get the values from Entity table and set the values in
												// Pojo class.
		{
			PostBloodRequirementPojo requirementList = new PostBloodRequirementPojo();
			BloodRequirementEntity requirementEntity = (BloodRequirementEntity) list.get(i);
			requirementList.setRequisterName(requirementEntity.getRequisterName());
			requirementList.setArea(requirementEntity.getArea());
			requirementList.setId(requirementEntity.getId());
			requirementList.setBloodGroup(requirementEntity.getBloodGroup());
			requirementList.setDate(requirementEntity.getDate());
			requirementList.setContactNumber(requirementEntity.getContactNumber());
			requirementList.setState(requirementEntity.getState());
			requirementList.setPinCode(requirementEntity.getPinCode());
			requirementList.setHospitalName(requirementEntity.getHospitalName());
			requirementList.setUserMailID(requirementEntity.getUserMailID());
			displayList.add(requirementList);
		}
		return displayList;
	}

	public int dateCheck(String requiredDate, String bookingDate) throws ParseException {
		int check = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse(bookingDate);
		Date date2 = formatter.parse(requiredDate);

		if (date.compareTo(date2) <= 0) {
			check = date.compareTo(date2);
		}

		return check;
	}

}
