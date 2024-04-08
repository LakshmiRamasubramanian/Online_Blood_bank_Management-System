package com.obbs.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obbs.dao.DonorDao;

import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.FeedbackPojo;
import com.obbs.model.PostBloodRequirementPojo;

import com.obbs.model.SlotBookingPojo;

@Service("donorService")
// Access the Methods from the donorDaoImpl through corresponding interface.
public class DonorServiceImpl implements DonorService {
	@Autowired
	DonorDao donorDao;

	@Override
	public int registerDonor(DonorPojo donorPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return donorDao.registerDonor(donorPojo);
	}

	@Override
	public List<PostBloodRequirementPojo> displayRequirements(String donorBloodGroup) throws ApplicationException {
		// TODO Auto-generated method stub
		return donorDao.displayRequirements(donorBloodGroup);
	}

	public int donorLogin(DonorPojo donorPojo) throws ApplicationException {
		return donorDao.donorLogin(donorPojo);
	}

	@Override
	public int confirmSlot(SlotBookingPojo slotBookingPojo) throws ApplicationException {

		return donorDao.confirmSlot(slotBookingPojo);
	}

	@Override
	public int deleteRequirement(int recipientId) throws ApplicationException {

		return donorDao.deleteRequirement(recipientId);
	}

	@Override
	public int feedbackEntry(FeedbackPojo feedbackPojo) throws ApplicationException {
		return donorDao.feedbackEntry(feedbackPojo);
	}

	@Override
	public List feedbackFetch(FeedbackPojo feedbackPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return donorDao.feedbackFetch(feedbackPojo);
	}

	@Override
	public int mailCheckDonor(DonorPojo donorPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return donorDao.mailCheckDonor(donorPojo);

	}

	@Override
	public int dateCheck(String requiredDate, String bookingDate) throws ParseException {
		// TODO Auto-generated method stub
		return donorDao.dateCheck(requiredDate, bookingDate);

	}

	@Override
	public List<PostBloodRequirementPojo> displayBloodCompatibility(String donorBloodGroup)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return donorDao.displayBloodCompatibility(donorBloodGroup);
	}

}
