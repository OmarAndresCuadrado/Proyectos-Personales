package com.serviguadanas.backend.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviguadanas.backend.dao.product.IProductDao;
import com.serviguadanas.backend.entity.product.ProductEntity;

@Service
public class IProductImplement implements IProductService {

	@Autowired
	private IProductDao productDao;

	@Override
	public List<ProductEntity> findAll() {

		return (List<ProductEntity>) productDao.findAll();

	}

	@Override
	public ProductEntity findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	public ProductEntity save(ProductEntity productEntity) {
		return productDao.save(productEntity);
	}

	@Override
	public void delete(Long id) {
		productDao.deleteById(id);
	}

}
