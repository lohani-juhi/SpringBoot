package com.juhi.cms_api.service;

import java.util.List;

import com.juhi.cms_api.model.DesignationMaster;

public interface DesignationService {

	List<DesignationMaster> getAll();

	DesignationMaster get(Integer id);

	DesignationMaster save(DesignationMaster designationDetail);

	void delete(Integer id);
	
	List<DesignationMaster> getActiveDesignation();

}
