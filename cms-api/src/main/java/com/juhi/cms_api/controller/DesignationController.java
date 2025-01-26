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

import com.juhi.cms_api.model.DesignationMaster;
import com.juhi.cms_api.service.DesignationService;

@RestController
@RequestMapping("/designation")
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@GetMapping
	public ResponseEntity<List<DesignationMaster>> getAllDesignation() {
		return ResponseEntity.ok(designationService.getAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DesignationMaster> getDesignationById(@PathVariable Integer id) {
		DesignationMaster desg = designationService.get(id);
		return desg != null && desg.getId() != null ? ResponseEntity.ok(desg)
				: new ResponseEntity<DesignationMaster>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<DesignationMaster> saveDesignation(@RequestBody DesignationMaster desgDetail) {
		DesignationMaster desg = designationService.save(desgDetail);
		return desg != null && desg.getId() != null ? ResponseEntity.ok(desg)
				: new ResponseEntity<DesignationMaster>(HttpStatus.NOT_MODIFIED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<DesignationMaster> updateDesignation(@PathVariable Integer id,
			@RequestBody DesignationMaster desgDetail) {
		if (id != null && desgDetail != null && desgDetail.getId().equals(id)) {
			DesignationMaster desg = designationService.save(desgDetail);
			return desg != null ? ResponseEntity.ok(desg)
					: new ResponseEntity<DesignationMaster>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<DesignationMaster>(HttpStatus.NOT_MODIFIED);

		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteByDesignation(@PathVariable Integer id) {
		if (id != null && designationService.get(id) != null) {
			designationService.delete(id);
			return ResponseEntity.ok("Deleted");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

}
