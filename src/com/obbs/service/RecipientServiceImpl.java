package com.obbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obbs.dao.RecipientDao;
import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.HospitalPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.RecipientPojo;

@Service("recipientService")
// Access the Methods from the RecipientDaoImpl through corresponding interface.
public class RecipientServiceImpl implements RecipientService {
	@Autowired
	RecipientDao recipientDao;

	@Override
	public List<DonorPojo> donorCheck(RecipientPojo recipientPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return recipientDao.donorCheck(recipientPojo);

	}

	@Override
	public int insertBloodRequirement(PostBloodRequirementPojo requisterPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return recipientDao.insertBloodRequirement(requisterPojo);
	}

	@Override
	public List<HospitalPojo> getAllHospitals() throws ApplicationException {

		return recipientDao.getAllHopitals();
	}

	@Override
	public int insertBloodRequirementDB(PostBloodRequirementPojo requisterPojo) throws ApplicationException {

		return recipientDao.insertBloodRequirementDB(requisterPojo);

	}

	@Override
	public List donorCompatibilityCheck(RecipientPojo recipientPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return recipientDao.donorCompatibilityCheck(recipientPojo);
	}

}
