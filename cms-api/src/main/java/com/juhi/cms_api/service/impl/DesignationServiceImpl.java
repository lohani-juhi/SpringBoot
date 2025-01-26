package com.juhi.cms_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhi.cms_api.model.DesignationMaster;
import com.juhi.cms_api.repo.DesignationRepo;
import com.juhi.cms_api.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepo designationRepo;

	@Override
	public List<DesignationMaster> getAll() {
		return designationRepo.findAll();
	}

	@Override
	public DesignationMaster get(Integer id) {
		Optional<DesignationMaster> desg = designationRepo.findById(id);
		return desg.isPresent() ? desg.get() : null;
	}

	@Override
	public DesignationMaster save(DesignationMaster designationDetail) {
		return designationRepo.save(designationDetail);
	}

	@Override
	public void delete(Integer id) {
		designationRepo.deleteById(id);
	}

	@Override
	public List<DesignationMaster> getActiveDesignation() {
		return designationRepo.findByActiveTrue();
	}

}
