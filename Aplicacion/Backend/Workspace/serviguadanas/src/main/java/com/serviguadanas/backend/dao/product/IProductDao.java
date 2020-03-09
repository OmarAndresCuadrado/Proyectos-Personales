package com.serviguadanas.backend.dao.product;

import org.springframework.data.repository.CrudRepository;

import com.serviguadanas.backend.entity.product.ProductEntity;

public interface IProductDao extends CrudRepository<ProductEntity, Long> {
	

}
