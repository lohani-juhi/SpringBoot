package com.juhi.cms_api.service;

import java.util.List;

import com.juhi.cms_api.model.EmployeeTypeMaster;

public interface EmployeeTypeService {
	List<EmployeeTypeMaster> getAll();

	EmployeeTypeMaster get(Integer id);

	EmployeeTypeMaster save(EmployeeTypeMaster empTypeDetail);

	void delete(Integer id);
}
