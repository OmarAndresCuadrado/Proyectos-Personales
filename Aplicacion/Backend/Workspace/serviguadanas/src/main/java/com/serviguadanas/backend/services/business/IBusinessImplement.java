package com.serviguadanas.backend.services.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviguadanas.backend.dao.business.IBusinessDao;
import com.serviguadanas.backend.entity.business.BusinessEntity;


@Service
public class IBusinessImplement implements IBusinessService {

	@Autowired
	private IBusinessDao businessDao;

	@Override
	public List<BusinessEntity> findAll() {

		return (List<BusinessEntity>) businessDao.findAll();

	}

	@Override
	public BusinessEntity findById(Long id) {
		return businessDao.findById(id).orElse(null);
	}

	@Override
	public BusinessEntity save(BusinessEntity businessEntity) {
		return businessDao.save(businessEntity);
	}

	@Override
	public void delete(Long id) {
		businessDao.deleteById(id);
	}

}
