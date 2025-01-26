package com.juhi.cms_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhi.cms_api.model.GenderMaster;
import com.juhi.cms_api.repo.GenderRepo;
import com.juhi.cms_api.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {

	@Autowired
	private GenderRepo genderDetailRepo;

	@Override
	public List<GenderMaster> getAll() {
		return genderDetailRepo.findAll();
	}

	@Override
	public GenderMaster get(Integer id) {
		Optional<GenderMaster> gender = genderDetailRepo.findById(id);
		return gender.isPresent() ? gender.get() : null;
	}

	@Override
	public GenderMaster save(GenderMaster genderDetail) {
		return genderDetailRepo.save(genderDetail);
	}

	@Override
	public void delete(Integer id) {
		genderDetailRepo.deleteById(id);
	}

}
