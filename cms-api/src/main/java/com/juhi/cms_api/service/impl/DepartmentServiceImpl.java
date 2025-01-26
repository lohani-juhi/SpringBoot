package com.juhi.cms_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhi.cms_api.model.DepartmentMaster;
import com.juhi.cms_api.repo.DepartmentRepo;
import com.juhi.cms_api.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public List<DepartmentMaster> getAll() {
		return departmentRepo.findAll();
	}

	@Override
	public DepartmentMaster get(Integer id) {
		Optional<DepartmentMaster> dept = departmentRepo.findById(id);
		return dept.isPresent() ? dept.get() : null;
	}

	@Override
	public DepartmentMaster save(DepartmentMaster departmentDetail) {
		return departmentRepo.save(departmentDetail);
	}

	@Override
	public void delete(Integer id) {
		departmentRepo.deleteById(id);
	}

	@Override
	public List<DepartmentMaster> getActiveDepartment() {
		return departmentRepo.findByActiveTrue();
	}

}
