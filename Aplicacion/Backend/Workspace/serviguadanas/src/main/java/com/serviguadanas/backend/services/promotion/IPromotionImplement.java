package com.serviguadanas.backend.services.promotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviguadanas.backend.dao.promotion.IPromotionDao;
import com.serviguadanas.backend.entity.promotion.PromotionEntity;


@Service
public class IPromotionImplement implements IPromotionService {

	@Autowired
	private IPromotionDao promotionDao;

	@Override
	public List<PromotionEntity> findAll() {

		return (List<PromotionEntity>) promotionDao.findAll();

	}

	@Override
	public PromotionEntity findById(Long id) {
		return promotionDao.findById(id).orElse(null);
	}

	@Override
	public PromotionEntity save(PromotionEntity promotionEntity) {
		return promotionDao.save(promotionEntity);
	}

	@Override
	public void delete(Long id) {
		promotionDao.deleteById(id);
	}

}
