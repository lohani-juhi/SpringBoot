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

import com.juhi.cms_api.model.AddressDetail;
import com.juhi.cms_api.service.AddressDetailService;

@RestController
@RequestMapping("/address")
public class AddressDetailController {

	@Autowired
	public AddressDetailService addDetailService;

	@GetMapping
	public ResponseEntity<List<AddressDetail>> getAllAddressDetail() {
		return ResponseEntity.ok(addDetailService.getAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<AddressDetail> getAdressDetailById(@PathVariable Integer id) {
		AddressDetail addr = addDetailService.get(id);
		return addr != null ? ResponseEntity.ok(addr) : new ResponseEntity<AddressDetail>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<AddressDetail> saveAdressDetailById(@RequestBody AddressDetail addDetail) {
		AddressDetail addr = addDetailService.save(addDetail);
		return addr != null && addr.getId() != null ? ResponseEntity.ok(addr)
				: new ResponseEntity<AddressDetail>(HttpStatus.NOT_MODIFIED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<AddressDetail> updateAdressDetailById(@PathVariable Integer id,
			@RequestBody AddressDetail addDetail) {
		if (id != null && addDetail != null && addDetail.getId().equals(id)) {
			AddressDetail addr = addDetailService.save(addDetail);
			return addr != null ? ResponseEntity.ok(addr) : new ResponseEntity<AddressDetail>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<AddressDetail>(HttpStatus.NOT_MODIFIED);
		}

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		if (id != null && addDetailService != null) {
			addDetailService.delete(id);
			return ResponseEntity.ok("Deleted");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

	}

}