package com.juhi.cms_api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juhi.cms_api.model.EmployeeMaster;

public interface EmployeeRepo extends JpaRepository<EmployeeMaster, Integer>{

	List<EmployeeMaster> findByActiveTrue();
    List<EmployeeMaster> findByDepartmentId(Integer id);
    List<EmployeeMaster> findByDesignationId(Integer id);

}
