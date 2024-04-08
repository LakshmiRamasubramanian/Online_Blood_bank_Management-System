package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to FeedbackEntity class which marks this class as a
		// Entity bean.
// This entity is used to process the Feedback in database.
@Table(name = "feedback_table")
public class FeedbackEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "city")
	private String city;

	@Column(name = "feedback")
	private String feedback;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public FeedbackEntity() {

	}

	public FeedbackEntity(int id, String name, String hospitalName, String city, String feedback) {
		super();
		this.id = id;
		this.name = name;
		this.hospitalName = hospitalName;
		this.city = city;
		this.feedback = feedback;
	}

}
