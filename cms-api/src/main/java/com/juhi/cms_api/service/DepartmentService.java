package com.juhi.cms_api.service;

import java.util.List;

import com.juhi.cms_api.model.DepartmentMaster;

public interface DepartmentService {

	List<DepartmentMaster> getAll();

	DepartmentMaster get(Integer id);

	DepartmentMaster save(DepartmentMaster departmentDetail);

	void delete(Integer id);
	
	List<DepartmentMaster> getActiveDepartment();
}
