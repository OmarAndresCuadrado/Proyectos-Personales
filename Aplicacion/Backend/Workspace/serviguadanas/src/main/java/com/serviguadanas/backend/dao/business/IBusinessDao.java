package com.serviguadanas.backend.dao.business;

import org.springframework.data.repository.CrudRepository;

import com.serviguadanas.backend.entity.business.BusinessEntity;

public interface IBusinessDao extends CrudRepository<BusinessEntity, Long> {
	

}
