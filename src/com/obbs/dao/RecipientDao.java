package com.obbs.dao;

import java.util.List;

import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.HospitalPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.RecipientPojo;

//This Interface is used to abstract the methods in RecipientDaoImpl class.
public interface RecipientDao {

	public int insertBloodRequirement(PostBloodRequirementPojo requisterPojo) throws ApplicationException;

	public List<DonorPojo> donorCheck(RecipientPojo recipientPojo) throws ApplicationException;

	public List<HospitalPojo> getAllHopitals() throws ApplicationException;

	public int insertBloodRequirementDB(PostBloodRequirementPojo requisterPojo) throws ApplicationException;

	public List donorCompatibilityCheck(RecipientPojo recipientPojo) throws ApplicationException;

}
