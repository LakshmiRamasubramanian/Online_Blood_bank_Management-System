package com.obbs.model;

import javax.validation.constraints.Max;

import javax.validation.constraints.Min;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

//this Pojo is used to stores the Users data for temporary processing.
public class UsersPojo {

	private int id;

	@Pattern(regexp = "^[ A-Za-z]+$", message = "Name should not contain numbers")
	@Size(min = 3, max = 50, message = "First Name should be between 3 and 50 characters")

	private String firstName;
	@Pattern(regexp = "^[ A-Za-z]+$", message = "Name should not contain numbers")
	@Size(min = 1, max = 50, message = "Last Name should be between 1 and 50 characters")

	private String lastName;
	@Min(value = 10, message = "Age should be above 10")
	@Max(value = 100, message = "Age should be below 100")
	private int age;

	private String gender;

	@Range(min = 1000000000, message = "Contact number must be 10 digits")
	private long contactNumber;
	@Email
	private String email;
	@Size(min = 3, max = 20, message = "Password should be between 3 and 20 characters")
	private String password;
	@Min(value = 10, message = "Weight should be above 10")
	@Max(value = 100, message = "Weight should be below 100")
	private int weight;

	private String state;

	private String area;
	@Range(min = 100000, max = 999999, message = "Pincode must be 6 digits")
	private int pinCode;

	private String bloodGroup;

	public int getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setContactNumber(long contactNumber2) {
		this.contactNumber = contactNumber2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getArea() {
		return area;
	}
}
