package com.obbs.model;

//this is used to store the temporary data of blood group.
public class BloodGroupPojo {
	private int id;
	private String bloodGroup;

	public String getBloodGroup() {
		return bloodGroup;
	}

	public int getId() {
		return id;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setId(int id) {
		this.id = id;
	}

}
