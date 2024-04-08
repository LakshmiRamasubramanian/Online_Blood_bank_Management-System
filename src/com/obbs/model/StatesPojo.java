package com.obbs.model;

//This Pojo is used to hold the fetched values from the database.
public class StatesPojo {

	private int stateId;
	private String state;

	public String getState() {
		return state;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStateId() {
		return stateId;
	}

}
