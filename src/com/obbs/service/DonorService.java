package com.obbs.service;

import java.text.ParseException;
import java.util.List;

import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.FeedbackPojo;
import com.obbs.model.PostBloodRequirementPojo;

import com.obbs.model.SlotBookingPojo;

//This is used to abstract the methods in DonorServiceImpl
public interface DonorService {

	public int donorLogin(DonorPojo donorPojo) throws ApplicationException;

	public int registerDonor(DonorPojo donorPojo) throws ApplicationException;

	public int confirmSlot(SlotBookingPojo slotBookingPojo) throws ApplicationException;

	public int deleteRequirement(int recipientId) throws ApplicationException;

	public List<PostBloodRequirementPojo> displayRequirements(String donorBloodGroup) throws ApplicationException;

	public List<FeedbackPojo> feedbackFetch(FeedbackPojo feedbackPojo) throws ApplicationException;

	public int feedbackEntry(FeedbackPojo feedbackPojo) throws ApplicationException;

	public int mailCheckDonor(DonorPojo donorPojo) throws ApplicationException;

	public int dateCheck(String requiredDate, String bookingDate) throws ParseException;

	public List<PostBloodRequirementPojo> displayBloodCompatibility(String donorBloodGroup) throws ApplicationException;
}
