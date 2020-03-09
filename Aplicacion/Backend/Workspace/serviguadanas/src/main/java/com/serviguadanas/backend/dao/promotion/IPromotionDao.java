package com.serviguadanas.backend.dao.promotion;

import org.springframework.data.repository.CrudRepository;

import com.serviguadanas.backend.entity.promotion.PromotionEntity;

public interface IPromotionDao extends CrudRepository<PromotionEntity, Long> {
	

}
