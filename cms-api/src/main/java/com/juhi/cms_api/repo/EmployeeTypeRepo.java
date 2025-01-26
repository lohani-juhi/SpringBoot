package com.juhi.cms_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juhi.cms_api.model.EmployeeTypeMaster;

public interface EmployeeTypeRepo extends JpaRepository<EmployeeTypeMaster, Integer>{

}
