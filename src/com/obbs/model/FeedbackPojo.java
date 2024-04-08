package com.obbs.model;

//This Pojo is used to store the temporary values of feedback provided by the user.
public class FeedbackPojo {
	private int id;
	private String name;
	private String hospitalName;
	private String city;
	private String feedback;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
