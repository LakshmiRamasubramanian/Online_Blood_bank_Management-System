package com.obbs.model;

//Recipient Pojo is used to store the temporary data of recipient during Operation.
public class RecipientPojo {
	private long contactNumber;
	private String state;
	private String area;
	private int pinCode;
	private String bloodGroup;

	public double getContactNumber() {
		return contactNumber;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getState() {
		return state;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setState(String state) {
		this.state = state;
	}

}
