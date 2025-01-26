package com.juhi.cms_api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cm_designation_master")
public class DesignationMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4014550812806679934L;

	@Id
	@GeneratedValue
	@Column(name = "pk_designation_id")
	private Integer id;

	@Column(name = "desg_name")
	private String name;

	@Column(name = "desg_desc")
	private String desc;

	@Column(name = "desg_status")
	private boolean active;

	@Column(name = "desg_level")
	private int level;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
