package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to BloodGroupEntity class which marks this class as a
		// Entity bean.
@Table(name = "blood_group") // This annotaion allows to Specify the details of the table that will be used
								// to persist the entity in the database.
public class BloodGroupEntity {

	@Id // This is used to Specify the Primary key
	@Column(name = "id")
	private int id;
	
	@Column(name = "blood_group")
	private String bloodGroup;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
