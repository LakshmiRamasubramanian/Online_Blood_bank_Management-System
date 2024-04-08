package com.obbs.model;

//This Pojo is used to store the data of Slot Booking by the donor for Particular Recipient.
public class SlotBookingPojo {
	private int donorId;
	private int recipientId;
	private String hospitalName;
	private String area;
	private String date;
	private String timeSlot;
	private String donorBloodGroup;
	private String recipientBloodGroup;
	private String userMailID;
	private String donorName;
	private String recipientName;
	private long contactNumber;
	private String requiredDate;

	public String getRequiredDate() {
		return requiredDate;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public String getUserMailID() {
		return userMailID;
	}

	public void setUserMailID(String userMailID) {
		this.userMailID = userMailID;
	}

	public String getDonorBloodGroup() {
		return donorBloodGroup;
	}

	public void setDonorBloodGroup(String donorBloodGroup) {
		this.donorBloodGroup = donorBloodGroup;
	}

	public String getRecipientBloodGroup() {
		return recipientBloodGroup;
	}

	public void setRecipientBloodGroup(String recipientBloodGroup) {
		this.recipientBloodGroup = recipientBloodGroup;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
