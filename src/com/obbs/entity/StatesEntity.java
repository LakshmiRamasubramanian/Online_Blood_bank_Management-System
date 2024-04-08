package com.obbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation used to StatesEntity class which marks this class as a Entity
		// bean.
// this Entity is used to fetch the State values from the database.
@Table(name = "state")
public class StatesEntity {

	@Id
	@Column(name = "state_id")
	private int stateId;

	@Column(name = "state_name")
	private String state;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
