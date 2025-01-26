package com.juhi.cms_api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cm_gender_master")
public class GenderMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8494844101227279435L;
	
	public GenderMaster() {
		
	}
	
	public GenderMaster(Integer id, String type, char code, boolean active) {
		super();
		this.id = id;
		this.type = type;
		this.code = code;
		this.active = active;
	}

	
	@Id
	@GeneratedValue
	@Column(name = "pk_gender_id") 
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "gender_type")
	private String type;
	
	@Column(name = "gender_code")
	private char code;
	
	@Column(name = "gender_status")
	private boolean active;

}
