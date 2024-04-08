package com.obbs.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obbs.dao.UsersDao;
import com.obbs.exception.ApplicationException;
import com.obbs.model.BloodGroupPojo;

import com.obbs.model.PostBloodRequirementPojo;

import com.obbs.model.SlotBookingPojo;
import com.obbs.model.UsersPojo;

@Service("usersService")
// Access the Methods from the UsersDaoImpl through corresponding interface.
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao usersDao;

	@Override
	public int registerUser(UsersPojo usersPojo) throws ApplicationException {

		return usersDao.registerUser(usersPojo);
	}

	@Override
	public int loginUser(UsersPojo usersPojo) throws ApplicationException {

		return usersDao.loginUser(usersPojo);
	}

	@Override
	public List<PostBloodRequirementPojo> displayRequirements() throws ApplicationException, ParseException {
		// TODO Auto-generated method stub
		return usersDao.displayRequirements();
	}

	@Override
	public List getAllStates() throws ApplicationException {

		return usersDao.getAllStates();
	}

	@Override
	public List<BloodGroupPojo> getAllBloodGroups() throws ApplicationException {
		// TODO Auto-generated method stub
		return usersDao.getAllBloodGroups();
	}

	@Override
	public int mailCheckUser(UsersPojo usersPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return usersDao.mailCheckUser(usersPojo);
	}

	@Override
	public List<SlotBookingPojo> inboxCheck(String userMailId) throws ParseException, ApplicationException {
		// TODO Auto-generated method stub
		return usersDao.inboxCheck(userMailId);
	}

}
