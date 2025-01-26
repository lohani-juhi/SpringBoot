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

import com.juhi.cms_api.model.EmployeeTypeMaster;
import com.juhi.cms_api.service.EmployeeTypeService;

@RestController
@RequestMapping("/employeeType")
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService empTypeService;

	@GetMapping
	public ResponseEntity<List<EmployeeTypeMaster>> getAllEmployeeType() {
		return ResponseEntity.ok(empTypeService.getAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<EmployeeTypeMaster> getEmployeeTypeById(@PathVariable Integer id) {
		EmployeeTypeMaster empType = empTypeService.get(id);
		return empType != null && empType.getId() != null ? ResponseEntity.ok(empType)
				: new ResponseEntity<EmployeeTypeMaster>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<EmployeeTypeMaster> saveEmployeeType(@RequestBody EmployeeTypeMaster empTypeDetail) {
		EmployeeTypeMaster empType = empTypeService.save(empTypeDetail);
		return empType != null && empType.getId() != null ? ResponseEntity.ok(empType)
				: new ResponseEntity<EmployeeTypeMaster>(HttpStatus.NOT_MODIFIED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<EmployeeTypeMaster> updateEmployeeType(@PathVariable Integer id,
			@RequestBody EmployeeTypeMaster empTypeDetail) {
		if (id != null && empTypeDetail != null && empTypeDetail.getId().equals(id)) {
			EmployeeTypeMaster empType = empTypeService.save(empTypeDetail);
			return empType != null ? ResponseEntity.ok(empType)
					: new ResponseEntity<EmployeeTypeMaster>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<EmployeeTypeMaster>(HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		if (id != null && empTypeService.get(id) != null) {
			empTypeService.delete(id);
			return ResponseEntity.ok("Deleted");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
