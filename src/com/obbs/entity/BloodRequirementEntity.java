package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to BloodRequirementEntity class which marks this class
		// as a Entity bean.
// This Entity is Used to Store the Values in database.These values were given
// by the recipient for Posting in the Home page
@Table(name = "blood_requirement") // This annotaion allows to Specify the details of the table that will be used
									// to persist the entity in the database.
// This is used to specify the table name.
public class BloodRequirementEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this is Used to Auto Increment the Value.
	private int id;
	@Column(name = "requister_name")
	private String requisterName;

	@Column(name = "contact_number")
	private long contactNumber;

	@Column(name = "state")
	private String state;

	@Column(name = "area")
	private String area;

	@Column(name = "pin_code")
	private int pinCode;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "user_mailID")
	private String userMailID;
	@Column(name = "date")
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserMailID() {
		return userMailID;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public int getId() {
		return id;
	}

	public String getRequisterName() {
		return requisterName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public String getState() {
		return state;
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

	public void setUserMailID(String userMailID) {
		this.userMailID = userMailID;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRequisterName(String requisterName) {
		this.requisterName = requisterName;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
