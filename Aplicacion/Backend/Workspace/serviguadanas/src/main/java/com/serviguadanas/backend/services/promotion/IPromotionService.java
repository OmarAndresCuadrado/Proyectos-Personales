package com.serviguadanas.backend.services.promotion;

import java.util.List;

import com.serviguadanas.backend.entity.promotion.PromotionEntity;



public interface IPromotionService  {

	public List<PromotionEntity> findAll();
	
	public PromotionEntity findById(Long id);
	
	public PromotionEntity save(PromotionEntity promotionEntity);
	
	public void delete(Long id);
	
}
