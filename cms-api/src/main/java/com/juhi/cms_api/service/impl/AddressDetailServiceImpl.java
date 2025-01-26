package com.juhi.cms_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhi.cms_api.model.AddressDetail;
import com.juhi.cms_api.repo.AddressDetailRepo;
import com.juhi.cms_api.service.AddressDetailService;

@Service
public class AddressDetailServiceImpl implements AddressDetailService {

	@Autowired
	private AddressDetailRepo addDetailRepo;

	@Override
	public List<AddressDetail> getAll() {
		return addDetailRepo.findAll();
	}

	@Override
	public AddressDetail get(Integer id) {
		Optional<AddressDetail> addr = addDetailRepo.findById(id);
		return addr.isPresent() ? addr.get() : null;
	}

	@Override
	public AddressDetail save(AddressDetail addDetail) {
		return addDetailRepo.save(addDetail);
	}

	@Override
	public void delete(Integer id) {
		addDetailRepo.deleteById(id);

	}

}
