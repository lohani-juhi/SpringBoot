package com.juhi.cms_api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cm_department_master")
public class DepartmentMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1149588220272813035L;
	
	@Id
	@GeneratedValue
	@Column(name ="pk_department_id")
	private Integer id;
	

	@Column(name="dept_name")
	private String name;
	
	@Column(name="dept_desc")
	private String desc;
	
	@Column(name="dept_status")
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
