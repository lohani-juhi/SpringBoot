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

import com.juhi.cms_api.model.GenderMaster;
import com.juhi.cms_api.service.GenderService;

@RestController
@RequestMapping("/gender")
public class GenderController {

	@Autowired
	private GenderService genderService;

	@GetMapping
	public ResponseEntity<List<GenderMaster>> getAllGender() {
		return ResponseEntity.ok(genderService.getAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<GenderMaster> getGenderById(@PathVariable Integer id) {
		GenderMaster gender = genderService.get(id);
		return gender != null ? ResponseEntity.ok(gender) : new ResponseEntity<GenderMaster>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<GenderMaster> saveGender(@RequestBody GenderMaster genderDetail) {
		GenderMaster gender = genderService.save(genderDetail);
		return gender != null && gender.getId() != null ? ResponseEntity.ok(gender)
				: new ResponseEntity<GenderMaster>(HttpStatus.NOT_MODIFIED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<GenderMaster> updateGender(@PathVariable Integer id, @RequestBody GenderMaster genderDetail) {
		if (id != null && genderDetail != null && genderDetail.getId().equals(id)) {
			GenderMaster gender = genderService.save(genderDetail);
			return gender != null && gender.getId() != null ? ResponseEntity.ok(gender)
					: new ResponseEntity<GenderMaster>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<GenderMaster>(HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteByGender(@PathVariable Integer id) {
		if (id != null && genderService.get(id) != null) {
			genderService.delete(id);
			return ResponseEntity.ok("Deleted");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

}
