package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to DonorEntity class which marks this class as a Entity
		// bean.
// This entity is used to Store the Values of New Donor Registration.
@Table(name = "donor_table") // This annotaion allows to Specify the details of the table that will be used
								// to persist the entity in the database.
public class DonorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "donor_name")
	private String donorName;

	@Column(name = "contact_number")
	private long contactNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "pin_code")
	private int pinCode;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name = "password")
	private String password;

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorName() {
		return donorName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public String getArea() {
		return area;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
