package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to SlotBookingEntity class which marks this class as a
		// Entity bean.
// This entity is used to store the slot booking details by the donor for
// particular recipient.
@Table(name = "slot_booking")
public class SlotBookingEntity {
	@Id
	@Column(name = "recipient_id")
	private int recipientId;

	@Column(name = "donor_id")
	private int donorId;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "area")
	private String area;

	@Column(name = "date")
	private String date;

	@Column(name = "time_slot")
	private String timeSlot;

	@Column(name = "user_mailID")
	private String userMailID;

	@Column(name = "donor_name")
	private String donorName;

	@Column(name = "recipient_name")
	private String recipientName;

	@Column(name = "contact_number")
	private long contactNumber;

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRecipientName() {
		return recipientName;
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

	public String getUserMailID() {
		return userMailID;
	}

	public void setUserMailID(String userMailID) {
		this.userMailID = userMailID;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

}
