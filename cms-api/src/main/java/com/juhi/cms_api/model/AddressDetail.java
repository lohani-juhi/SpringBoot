package com.juhi.cms_api.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cm_address_detail")
public class AddressDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1723053896621466572L;

	@Id
	@GeneratedValue
	@Column(name = "pk_address_id")
	private Integer id;

	@OneToOne(targetEntity = EmployeeMaster.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_emp_id", referencedColumnName = "pk_emp_id")
	private EmployeeMaster employee;

	@Column(name = "zipcode")
	private String zipCode;

	@Column(name = "add_line1")
	private String addLine1;

	@Column(name = "add_line2")
	private String addLine2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "current_add")
	private boolean current_add;

	@Column(name = "permanent_add")
	private boolean permanent_add;

	@Column(name = "owner_name")
	private String owner_name;

	@Column(name = "owner_contact")
	private String owner_contact;

	@Column(name = "rented")
	private boolean rented;

	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Column(name = "from_date")
	private String fromDate;

	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Column(name = "to_date")
	private String toDate;

	@Column(name = "landmark")
	private String landmark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmployeeMaster getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeMaster employee) {
		this.employee = employee;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isCurrent_add() {
		return current_add;
	}

	public void setCurrent_add(boolean current_add) {
		this.current_add = current_add;
	}

	public boolean isPermanent_add() {
		return permanent_add;
	}

	public void setPermanent_add(boolean permanent_add) {
		this.permanent_add = permanent_add;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_contact() {
		return owner_contact;
	}

	public void setOwner_contact(String owner_contact) {
		this.owner_contact = owner_contact;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

}
