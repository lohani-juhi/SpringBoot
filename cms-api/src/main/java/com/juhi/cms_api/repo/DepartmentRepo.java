package com.juhi.cms_api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juhi.cms_api.model.DepartmentMaster;

public interface DepartmentRepo extends JpaRepository<DepartmentMaster, Integer>{
	
	List<DepartmentMaster> findByActiveTrue();

	@Override
	Optional<DepartmentMaster> findById(Integer id);
    



}
