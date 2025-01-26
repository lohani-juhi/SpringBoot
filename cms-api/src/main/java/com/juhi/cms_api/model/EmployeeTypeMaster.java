package com.juhi.cms_api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cm_emptype_master")

public class EmployeeTypeMaster  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6410898675700526591L;
	
	@Id
	@GeneratedValue
	@Column(name ="pk_emp_type_id")
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name ="emp_type")
	private String type;
	
	@Column(name="emptype_status")
	private boolean active;
	
	@Column(name="emptype_desc")
	private String desc;

}
