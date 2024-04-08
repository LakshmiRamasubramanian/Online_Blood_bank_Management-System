package com.obbs.service;

import java.util.List;

import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.HospitalPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.RecipientPojo;

//This is used to abstract the methods in RecipientServiceImpl
public interface RecipientService {

	public List<DonorPojo> donorCheck(RecipientPojo recipientPojo) throws ApplicationException;

	public int insertBloodRequirement(PostBloodRequirementPojo requisterPojo) throws ApplicationException;

	public List<HospitalPojo> getAllHospitals() throws ApplicationException;

	public int insertBloodRequirementDB(PostBloodRequirementPojo requisterPojo) throws ApplicationException;

	public List donorCompatibilityCheck(RecipientPojo recipientPojo) throws ApplicationException;
}
