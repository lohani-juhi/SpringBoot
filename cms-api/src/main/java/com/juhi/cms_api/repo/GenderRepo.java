package com.juhi.cms_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juhi.cms_api.model.GenderMaster;

public interface GenderRepo extends JpaRepository<GenderMaster, Integer> {

}
