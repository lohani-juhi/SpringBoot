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

import com.juhi.cms_api.model.DepartmentMaster;
import com.juhi.cms_api.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<List<DepartmentMaster>> getAllDepartment() {
		return ResponseEntity.ok(departmentService.getAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DepartmentMaster> getDepartmentById(@PathVariable Integer id) {
		DepartmentMaster dept = departmentService.get(id);
		return dept != null ? ResponseEntity.ok(dept) : new ResponseEntity<DepartmentMaster>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<DepartmentMaster> saveDepartment(@RequestBody DepartmentMaster deptDetail) {
		DepartmentMaster dept = departmentService.save(deptDetail);
		return dept != null && dept.getId() != null ? ResponseEntity.ok(dept)
				: new ResponseEntity<DepartmentMaster>(HttpStatus.NOT_MODIFIED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<DepartmentMaster> updateDepartment(@PathVariable Integer id,
			@RequestBody DepartmentMaster deptDetail) {
		if (id != null && deptDetail != null && deptDetail.getId().equals(id)) {
			DepartmentMaster dept = departmentService.save(deptDetail);
			return dept != null ? ResponseEntity.ok(dept)
					: new ResponseEntity<DepartmentMaster>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<DepartmentMaster>(HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteByDepartment(@PathVariable Integer id) {
		if (id != null && departmentService.get(id) != null) {
			departmentService.delete(id);
			return ResponseEntity.ok("Deleted");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
