package com.obbs.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

//This is used to store the temporary data of Donor during specified Operations.
public class DonorPojo {
	private int id;
	@Pattern(regexp = "^[ A-Za-z]+$", message = "Name should not contain numbers")
	@Size(min = 3, max = 50, message = "Name should not exceed 50 characters")
	private String donorName;
	@Range(min = 1000000000, message = "Contact number must be 10 digits")
	private long contactNumber;
	private String state;
	private String area;

	@Range(min = 100000, max = 999999, message = "Pincode must be 6 digits")
	private int pinCode;
	private String bloodGroup;
	@Email
	private String email;
	@Size(min = 3, max = 20, message = "Password should be between 3 to 20 characters")
	private String password;

	

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getId() {
		return id;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public String getState() {
		return state;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
