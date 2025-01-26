package com.juhi.cms_api.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cm_emp_master")
public class EmployeeMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2560075945231238642L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_emp_id")
	private Integer id;

	@Column(name = "emp_first_name")
	private String firstName;

	@Column(name = "emp_middle_name")
	private String middleName;

	@Column(name = "emp_last_name")
	private String lastName;

	@Column(name = "emp_code")
	private String code;

	@Column(name = "emp_dob")
	private String dob;

	@OneToOne(targetEntity = GenderMaster.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_gender_id", referencedColumnName = "pk_gender_id")
	private GenderMaster gender;

	@OneToOne(targetEntity = DepartmentMaster.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_dep_id", referencedColumnName = "pk_department_id")
	private DepartmentMaster department;

	@Column(name = "emp_emailId")
	private String emailId;

	@Column(name = "emp_status")
	private boolean active;

	@OneToOne(targetEntity = DesignationMaster.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_desg_id", referencedColumnName = "pk_designation_id")
	private DesignationMaster designation;

	@Column(name = "emp_contactNo")
	private String contactNo;

	@OneToOne(targetEntity = EmployeeTypeMaster.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_emp_type_id", referencedColumnName = "pk_emp_type_id")
	private EmployeeTypeMaster empType;

	@Column(name = "emp_imgUrl")
	private String imgUrl;

	public EmployeeTypeMaster getEmptype() {
		return empType;
	}

	public void setEmptype(EmployeeTypeMaster empType) {
		this.empType = empType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public DesignationMaster getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationMaster designation) {
		this.designation = designation;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public GenderMaster getGender() {
		return gender;
	}

	public void setGender(GenderMaster gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public DepartmentMaster getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentMaster department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "ID : " + getId() + "; " + "Name : " + getFirstName() + "; " + "Gender : " + getGender().getType() + "; "
				+ "dob : " + getDob() + "; " + "empcode : " + getCode() + "; " + "active : " + isActive() + "; ";
	}

}
