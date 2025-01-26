package com.juhi.cms_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juhi.cms_api.model.EmployeeMaster;
import com.juhi.cms_api.service.EmployeeService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/employee")
@Transactional
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping
	public ResponseEntity<List<EmployeeMaster>> getAllEmployee() {
		return ResponseEntity.ok(empService.getAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<EmployeeMaster> getEmployeeById(@PathVariable Integer id) {
		EmployeeMaster emp = empService.get(id);
		return emp != null && emp.getId() != null ? ResponseEntity.ok(emp)
				: new ResponseEntity<EmployeeMaster>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/list")
	public ResponseEntity<List<EmployeeMaster>> getActiveEmployee() {
		return ResponseEntity.ok(empService.getActiveEmployee());
	}

	@GetMapping("/department/{id}")
	public List<EmployeeMaster> getEmployeeByDepartment(@PathVariable Integer id) {
		return empService.getEmployeesByDepartmentId(id);
	}
	
	@GetMapping("/designation/{id}")
	public List<EmployeeMaster> getEmployeeByDesignation(@PathVariable Integer id) {
		return empService.getEmployeesByDesignationId(id);
	}

	@PostMapping
	public ResponseEntity<EmployeeMaster> saveEmployee(@RequestBody EmployeeMaster empDetail) {
		EmployeeMaster emp = empService.save(empDetail);
		return emp != null && emp.getId() != null ? ResponseEntity.ok(emp)
				: new ResponseEntity<EmployeeMaster>(HttpStatus.NOT_MODIFIED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<EmployeeMaster> updateEmployee(@PathVariable Integer id,
			@RequestBody EmployeeMaster empDetail) {
		if (id != null && empDetail != null && empDetail.getId().equals(id)) {
			EmployeeMaster emp = empService.save(empDetail);
			return emp != null ? ResponseEntity.ok(emp) : new ResponseEntity<EmployeeMaster>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<EmployeeMaster>(HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		if (id != null && empService.get(id) != null) {
			empService.delete(id);
			return ResponseEntity.ok("Deleted");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

}
