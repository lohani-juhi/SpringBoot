package com.juhi.cms_api.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhi.cms_api.model.EmployeeMaster;
import com.juhi.cms_api.repo.EmployeeRepo;
import com.juhi.cms_api.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public List<EmployeeMaster> getAll() {
		return empRepo.findAll();
	}

	@Override
	public EmployeeMaster get(Integer id) {
		Optional<EmployeeMaster> emp = empRepo.findById(id);
		return emp.isPresent() ? emp.get() : null;
	}

	@Override
	public EmployeeMaster save(EmployeeMaster empDetail) {
		System.out.println(empDetail);
		return empRepo.save(empDetail);
	}

	@Override
	public void delete(Integer id) {
		empRepo.deleteById(id);
	}

	@Override
	public List<EmployeeMaster> getActiveEmployee() {
		return empRepo.findByActiveTrue();
	}

	private String getEmployeeCode(String lastName) {
		String prefix = "CM";
		String year = String.valueOf(LocalDateTime.now().getYear()).substring(2);

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
		String currentTime = LocalDateTime.now().format(timeFormatter);
		if (lastName != null) {
			return prefix + lastName.toUpperCase().charAt(0) + year + currentTime;
		}
		else {
			return prefix + "X" + year + currentTime;
		}

	}

	@Override
	public List<EmployeeMaster> getEmployeesByDepartmentId(Integer id) {
		return empRepo.findByDepartmentId(id);
	}

	@Override
	public List<EmployeeMaster> getEmployeesByDesignationId(Integer id) {
		return empRepo.findByDesignationId(id);
	}



}
