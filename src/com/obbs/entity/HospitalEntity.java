package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to HospitalEntity class which marks this class as a
		// Entity bean.
// This entity is used to fetch the hospital names from the database.
@Table(name = "hospital_name")
public class HospitalEntity {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "hospital_name")
	private String hospitalName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
