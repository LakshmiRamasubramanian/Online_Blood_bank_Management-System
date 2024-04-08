package com.obbs.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

//This Pojo is used to process the requirement data inserted by the recipient during process.
public class PostBloodRequirementPojo {
	private int id;

	@Pattern(regexp = "^[ A-Za-z]+$", message = "Name should not contain numbers")
	@Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
	private String requisterName;

	@Range(min = 1000000000, message = "Contact number must be 10 digits")
	private long contactNumber;

	private String state;
	private String area;

	@Range(min = 100000, max = 999999, message = "Pincode must be 6 digits")
	private int pinCode;
	private String bloodGroup;
	private String hospitalName;
	@Email
	private String userMailID;

	private String date;

	public void setId(int id) {
		this.id = id;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setUserMailID(String userMailID) {
		this.userMailID = userMailID;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setRequisterName(String requisterName) {
		this.requisterName = requisterName;
	}

	public String getRequisterName() {
		return requisterName;
	}

	public int getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public String getUserMailID() {
		return userMailID;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public String getArea() {
		return area;
	}

	public int getPinCode() {
		return pinCode;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

}
