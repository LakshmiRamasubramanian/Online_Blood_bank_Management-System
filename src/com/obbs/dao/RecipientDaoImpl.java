package com.obbs.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.obbs.entity.BloodRequirementEntity;
import com.obbs.entity.DonorEntity;
import com.obbs.entity.HospitalEntity;
import com.obbs.entity.RecipientDetailsEntity;
import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.HospitalPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.RecipientPojo;

@Repository("recipientDao")
public class RecipientDaoImpl implements RecipientDao {

	@Override // If no donor found,the recipient post his/her requirements
	public int insertBloodRequirement(PostBloodRequirementPojo requisterPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			BloodRequirementEntity requisterEntity = new BloodRequirementEntity();
			requisterEntity.setUserMailID(requisterPojo.getUserMailID());
			requisterEntity.setRequisterName(requisterPojo.getRequisterName());
			requisterEntity.setContactNumber(requisterPojo.getContactNumber());
			requisterEntity.setState(requisterPojo.getState());
			requisterEntity.setArea(requisterPojo.getArea());
			requisterEntity.setPinCode(requisterPojo.getPinCode());
			requisterEntity.setBloodGroup(requisterPojo.getBloodGroup());
			requisterEntity.setHospitalName(requisterPojo.getHospitalName());
			requisterEntity.setDate(requisterPojo.getDate());
			session.save(requisterEntity);
			transaction.commit();

		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return 1;
	}

	@Override // List of Hospitals
	public List<HospitalPojo> getAllHopitals() throws ApplicationException {

		List<HospitalPojo> hospitalList = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			List list = session.createQuery("from HospitalEntity").list();
			hospitalList = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				HospitalPojo hospitalPojo = new HospitalPojo();
				HospitalEntity hospitalEntity = (HospitalEntity) list.get(i);
				hospitalPojo.setHospitalName(hospitalEntity.getHospitalName());
				hospitalList.add(hospitalPojo);
			}

		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return hospitalList;
	}

	@Override
	// Inserting the requirements by the recipient in database.
	public int insertBloodRequirementDB(PostBloodRequirementPojo requisterPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			RecipientDetailsEntity recipientEntity = new RecipientDetailsEntity();
			recipientEntity.setRequisterName(requisterPojo.getRequisterName());
			recipientEntity.setContactNumber(requisterPojo.getContactNumber());
			recipientEntity.setState(requisterPojo.getState());
			recipientEntity.setArea(requisterPojo.getArea());
			recipientEntity.setPinCode(requisterPojo.getPinCode());
			recipientEntity.setBloodGroup(requisterPojo.getBloodGroup());
			recipientEntity.setHospitalName(requisterPojo.getHospitalName());
			session.save(recipientEntity);
			transaction.commit();

		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return 1;
	}

	@Override
	// This is used to find the list of blood group matched donors
	public List donorCheck(RecipientPojo recipientPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		List<DonorPojo> details = null;
		List<DonorPojo> detailsList = null;
		List list = null;
		String recipientBloodGroup = recipientPojo.getBloodGroup();
		String recipientArea = recipientPojo.getArea();

		details = new ArrayList<DonorPojo>();
		detailsList = new ArrayList<DonorPojo>();
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			System.out.println("rec dao");
			Query query = session.createQuery("from DonorEntity where blood_group=:recipientBloodGroup");
			query.setParameter("recipientBloodGroup", recipientBloodGroup);

			list = query.getResultList();
			detailsList = searchForLoop(list, details, recipientArea);
		}

		catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return detailsList;
	}

	@Override // Checking if any compatible donor matches his/her requirements
	public List donorCompatibilityCheck(RecipientPojo recipientPojo) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;
		List<DonorPojo> details = null;
		List<DonorPojo> detailsList = null;
		String recipientArea = recipientPojo.getArea();
		String recipientBloodGroup = recipientPojo.getBloodGroup();
		details = new ArrayList<DonorPojo>();
		detailsList = new ArrayList<DonorPojo>();
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			if (recipientBloodGroup.equals("A +ve")) {
				List list = session.createQuery(
						"from DonorEntity where blood_group like 'A -ve' or blood_group like 'O +ve' or blood_group like 'O -ve'")
						.list();
				detailsList = searchForLoop(list, details, recipientArea);
			} else if (recipientBloodGroup.equals("A -ve")) {
				List list = session.createQuery("from DonorEntity where blood_group like 'O -ve'").list();
				detailsList = searchForLoop(list, details, recipientArea);
			} else if (recipientBloodGroup.equals("B +ve")) {
				List list = session.createQuery(
						"from DonorEntity where blood_group like 'B -ve'or blood_group like 'O +ve' or blood_group like 'O -ve'")
						.list();
				detailsList = searchForLoop(list, details, recipientArea);
			} else if (recipientBloodGroup.equals("B -ve")) {
				List list = session.createQuery("from DonorEntity where blood_group like 'O -ve'").list();
				detailsList = searchForLoop(list, details, recipientArea);
			} else if (recipientBloodGroup.equals("AB +ve")) {
				List list = session.createQuery(
						"from DonorEntity where blood_group like 'O -ve' or where blood_group like 'A -ve' or where blood_group like 'B -ve' or where blood_group like 'AB -ve' or where blood_group like 'O +ve' or where blood_group like 'A +ve' or where blood_group like 'B +ve'")
						.list();
				detailsList = searchForLoop(list, details, recipientArea);
			} else if (recipientBloodGroup.equals("AB -ve")) {
				List list = session.createQuery(
						"from DonorEntity where blood_group like 'B -ve'or blood_group like 'A -ve' or blood_group like 'O -ve'")
						.list();
				detailsList = searchForLoop(list, details, recipientArea);
			} else if (recipientBloodGroup.equals("O +ve")) {
				List list = session.createQuery("from DonorEntity where blood_group like 'O -ve'").list();
				detailsList = searchForLoop(list, details, recipientArea);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			session.close();
		}
		return detailsList;
	}

	// For loop
	public List searchForLoop(List list, List<DonorPojo> details, String recipientArea) {
		for (int i = 0; i < list.size(); i++) {
			DonorEntity donorEntity = (DonorEntity) list.get(i);
			DonorPojo donorPojo = new DonorPojo();
			if (recipientArea.equalsIgnoreCase(donorEntity.getArea())) {
				donorPojo.setId(donorEntity.getId());
				donorPojo.setDonorName(donorEntity.getDonorName());
				donorPojo.setArea(donorEntity.getArea());
				donorPojo.setBloodGroup(donorEntity.getBloodGroup());
				donorPojo.setContactNumber(donorEntity.getContactNumber());
				donorPojo.setPinCode(donorEntity.getPinCode());
				donorPojo.setState(donorEntity.getState());
				details.add(donorPojo);
			}
		}
		return details;
	}

}
