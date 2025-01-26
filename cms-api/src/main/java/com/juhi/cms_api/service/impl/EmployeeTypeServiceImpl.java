package com.juhi.cms_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhi.cms_api.model.EmployeeTypeMaster;
import com.juhi.cms_api.repo.EmployeeTypeRepo;
import com.juhi.cms_api.service.EmployeeTypeService;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepo empTypeRepo;

	@Override
	public List<EmployeeTypeMaster> getAll() {
		return empTypeRepo.findAll();
	}

	@Override
	public EmployeeTypeMaster get(Integer id) {
		Optional<EmployeeTypeMaster> empType = empTypeRepo.findById(id);
		return empType.isPresent() ? empType.get() : null;
	}

	@Override
	public EmployeeTypeMaster save(EmployeeTypeMaster empTypeDetail) {
		return empTypeRepo.save(empTypeDetail);
	}

	@Override
	public void delete(Integer id) {
		empTypeRepo.deleteById(id);
	}

}
