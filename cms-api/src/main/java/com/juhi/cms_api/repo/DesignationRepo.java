package com.juhi.cms_api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juhi.cms_api.model.DesignationMaster;

public interface DesignationRepo extends JpaRepository<DesignationMaster, Integer>{
	
	List<DesignationMaster> findByActiveTrue();

	@Override
	Optional<DesignationMaster> findById(Integer id);


}
