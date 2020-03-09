package com.serviguadanas.backend.services.business;

import java.util.List;

import com.serviguadanas.backend.entity.business.BusinessEntity;



public interface IBusinessService  {

	public List<BusinessEntity> findAll();
	
	public BusinessEntity findById(Long id);
	
	public BusinessEntity save(BusinessEntity businessEntity);
	
	public void delete(Long id);
	
}
