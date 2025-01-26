package com.juhi.cms_api.service;

import java.util.List;

import com.juhi.cms_api.model.GenderMaster;

public interface GenderService {

	List<GenderMaster> getAll();

	GenderMaster get(Integer id);

	GenderMaster save(GenderMaster genderDetail);

	void delete(Integer id);

}
