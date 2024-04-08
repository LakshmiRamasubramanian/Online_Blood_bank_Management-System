package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to UsersEntity class which marks this class as a Entity
		// bean.
// This entity is used to Process the Users Data in data base.
@Table(name = "users_table")
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "contact_number")
	private double contactNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "weight")
	private int weight;

	@Column(name = "state")
	private String state;

	@Column(name = "area")
	private String area;

	@Column(name = "pin_code")
	private int pinCode;

	@Column(name = "blood_group")
	private String bloodGroup;

	public int getId() {
		return id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setContactNumber(double contactNumber2) {
		this.contactNumber = contactNumber2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getWeight() {
		return weight;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getArea() {
		return area;
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
