package com.obbs.service;

import java.text.ParseException;
import java.util.List;

import com.obbs.exception.ApplicationException;
import com.obbs.model.BloodGroupPojo;

import com.obbs.model.PostBloodRequirementPojo;

import com.obbs.model.SlotBookingPojo;
import com.obbs.model.UsersPojo;

//This is used to abstract the methods in UsersServiceImpl
public interface UsersService {

	public int registerUser(UsersPojo usersPojo) throws ApplicationException;

	public int loginUser(UsersPojo usersPojo) throws ApplicationException;

	public List<PostBloodRequirementPojo> displayRequirements() throws ApplicationException, ParseException;

	public List getAllStates() throws ApplicationException;

	public List<BloodGroupPojo> getAllBloodGroups() throws ApplicationException;

	public int mailCheckUser(UsersPojo usersPojo) throws ApplicationException;

	public List<SlotBookingPojo> inboxCheck(String userMailId) throws ParseException, ApplicationException;

}
