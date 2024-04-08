package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to RecipientDetailsEntity class which marks this class
		// as a Entity bean.
// This entity is used to process the recipient Details in the database.
@Table(name = "recipient_details")
public class RecipientDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "requister_name")
	private String requisterName;

	@Column(name = "contact_number")
	private long contactNumber;

	@Column(name = "area")
	private String area;

	@Column(name = "pin_code")
	private int pinCode;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "state")
	private String state;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getRequisterName() {
		return requisterName;
	}

	public void setRequisterName(String requisterName) {
		this.requisterName = requisterName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
