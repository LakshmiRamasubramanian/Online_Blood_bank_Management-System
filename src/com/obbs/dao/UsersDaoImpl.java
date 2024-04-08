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

import com.obbs.entity.BloodGroupEntity;
import com.obbs.entity.BloodRequirementEntity;

import com.obbs.entity.SlotBookingEntity;
import com.obbs.entity.StatesEntity;
import com.obbs.entity.UsersEntity;
import com.obbs.exception.ApplicationException;
import com.obbs.model.BloodGroupPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.SlotBookingPojo;
import com.obbs.model.StatesPojo;
import com.obbs.model.UsersPojo;

@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {

	@Override // User register his/her details
	public int registerUser(UsersPojo usersPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			double contactNumber;
			UsersEntity usersEntity = new UsersEntity();
			usersEntity.setFirstName(usersPojo.getFirstName());
			usersEntity.setLastName(usersPojo.getLastName());
			usersEntity.setAge(usersPojo.getAge());
			usersEntity.setGender(usersPojo.getGender());
			contactNumber = (double) (usersPojo.getContactNumber());
			usersEntity.setContactNumber(contactNumber);
			usersEntity.setEmail(usersPojo.getEmail());
			usersEntity.setPassword(usersPojo.getPassword());
			usersEntity.setWeight(usersPojo.getWeight());
			usersEntity.setState(usersPojo.getState());
			usersEntity.setArea(usersPojo.getArea());
			usersEntity.setPinCode(usersPojo.getPinCode());
			usersEntity.setBloodGroup(usersPojo.getBloodGroup());
			session.save(usersEntity);
			transaction.commit();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return 1;
	}

	@Override // Authentication of User's Login
	public int loginUser(UsersPojo usersPojo) throws ApplicationException {
		int login = 0;
		SessionFactory sessionfactory = null;
		Session session = null;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			List list = session.createQuery("from UsersEntity").list();
			for (int i = 0; i < list.size(); i++) {
				UsersEntity usersEntity = (UsersEntity) list.get(i);
				if (usersPojo.getEmail().equals(usersEntity.getEmail())
						&& usersPojo.getPassword().equals(usersEntity.getPassword())) {
					login = 1;
				}

			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return login;
	}

	@Override // Any viewer can view the blood requirements of recipients
	public List<PostBloodRequirementPojo> displayRequirements() throws ApplicationException, ParseException {

		List<PostBloodRequirementPojo> displayList = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date dd = new Date();

		Date todayDate = formatter.parse(formatter.format(dd));
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			List list = session.createQuery("from BloodRequirementEntity").list();
			displayList = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				PostBloodRequirementPojo requirementList = new PostBloodRequirementPojo();
				BloodRequirementEntity requirementEntity = (BloodRequirementEntity) list.get(i);
				Date date = formatter.parse(requirementEntity.getDate());

				if (date.compareTo(todayDate) >= 0) {
					requirementList.setRequisterName(requirementEntity.getRequisterName());
					requirementList.setArea(requirementEntity.getArea());
					requirementList.setId(requirementEntity.getId());
					requirementList.setBloodGroup(requirementEntity.getBloodGroup());
					requirementList.setContactNumber(requirementEntity.getContactNumber());
					requirementList.setState(requirementEntity.getState());
					requirementList.setPinCode(requirementEntity.getPinCode());
					requirementList.setHospitalName(requirementEntity.getHospitalName());
					requirementList.setDate(requirementEntity.getDate());
					displayList.add(requirementList);
				}
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return displayList;
	}

	@Override // List of states
	public List getAllStates() throws ApplicationException {
		List<StatesPojo> statesList = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			List list = session.createQuery("from StatesEntity").list();
			statesList = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				StatesPojo statesPojo = new StatesPojo();
				StatesEntity statesEntity = (StatesEntity) list.get(i);
				statesPojo.setStateId(statesEntity.getStateId());
				statesPojo.setState(statesEntity.getState());
				statesList.add(statesPojo);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return statesList;
	}

	@Override // List of blood groups
	public List<BloodGroupPojo> getAllBloodGroups() throws ApplicationException {
		List<BloodGroupPojo> bloodGroupList = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			List list = session.createQuery("from BloodGroupEntity").list();
			bloodGroupList = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				BloodGroupPojo bloodGroupPojo = new BloodGroupPojo();
				BloodGroupEntity bloodGroupEntity = (BloodGroupEntity) list.get(i);
				bloodGroupPojo.setId(bloodGroupEntity.getId());
				bloodGroupPojo.setBloodGroup(bloodGroupEntity.getBloodGroup());
				bloodGroupList.add(bloodGroupPojo);

			}

		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return bloodGroupList;
	}

	@Override
	// This is used to check the New Mail Id going to be registered by the new donor
	// with the already existed mail Id in dastabase
	public int mailCheckUser(UsersPojo usersPojo) throws ApplicationException {
		int mail = 0;
		SessionFactory sessionfactory = null;
		Session session = null;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			List list = session.createQuery("from UsersEntity").list();
			for (int i = 0; i < list.size(); i++) {
				UsersEntity usersEntity = (UsersEntity) list.get(i);
				if (usersPojo.getEmail().equals(usersEntity.getEmail())) {
					mail = 3;
				}
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return mail;
	}

	@Override
	// This is used to check the slot and donor details for the recipient posted by user
	public List<SlotBookingPojo> inboxCheck(String userMailId) throws ParseException, ApplicationException {
		List<SlotBookingPojo> displayList = null;
		List list = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date dd = new Date();

		Date todayDate = formatter.parse(formatter.format(dd));
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.createQuery("from SlotBookingEntity where user_mailID=:user");
			query.setParameter("user", userMailId);
			displayList = new ArrayList();
			list = query.getResultList();

			for (int i = 0; i < list.size(); i++) {

				SlotBookingPojo inboxList = new SlotBookingPojo();
				SlotBookingEntity inboxEntity = (SlotBookingEntity) list.get(i);
				Date date = formatter.parse(inboxEntity.getDate());

				if (date.compareTo(todayDate) >= 0) {
					inboxList.setRecipientId(inboxEntity.getRecipientId());
					inboxList.setRecipientName(inboxEntity.getRecipientName());
					inboxList.setDonorId(inboxEntity.getDonorId());
					inboxList.setDate(inboxEntity.getDate());
					inboxList.setTimeSlot(inboxEntity.getTimeSlot());
					inboxList.setHospitalName(inboxEntity.getHospitalName());
					inboxList.setArea(inboxEntity.getArea());
					inboxList.setDonorName(inboxEntity.getDonorName());
					inboxList.setContactNumber(inboxEntity.getContactNumber());
					displayList.add(inboxList);
				}
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return displayList;
	}

}
