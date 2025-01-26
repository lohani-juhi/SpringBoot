package com.juhi.cms_api.service;

import java.util.List;

import com.juhi.cms_api.model.AddressDetail;

public interface AddressDetailService {

	List<AddressDetail> getAll();

	AddressDetail get(Integer id);

	AddressDetail save(AddressDetail addDetail);

	void delete(Integer id);

}
