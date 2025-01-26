package com.juhi.cms_api.service;

import java.util.List;

import com.juhi.cms_api.model.EmployeeMaster;

public interface EmployeeService {
	List<EmployeeMaster> getAll();

	EmployeeMaster get(Integer id);

	EmployeeMaster save(EmployeeMaster empDetail);

	void delete(Integer id);
	
	List<EmployeeMaster> getActiveEmployee();
	
	List<EmployeeMaster> getEmployeesByDepartmentId(Integer id);
	
	List<EmployeeMaster> getEmployeesByDesignationId(Integer id);

}
