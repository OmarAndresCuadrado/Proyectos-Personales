package com.serviguadanas.backend.services.product;

import java.util.List;

import com.serviguadanas.backend.entity.product.ProductEntity;


public interface IProductService  {

	public List<ProductEntity> findAll();
	
	public ProductEntity findById(Long id);
	
	public ProductEntity save(ProductEntity productEntity);
	
	public void delete(Long id);
	
}
