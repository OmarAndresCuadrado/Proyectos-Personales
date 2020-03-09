package com.serviguadanas.backend.controller.promotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviguadanas.backend.entity.promotion.PromotionEntity;
import com.serviguadanas.backend.services.message.MessageImp;
import com.serviguadanas.backend.services.promotion.IPromotionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	private IPromotionService promotionService;
	
	@Autowired
	private MessageImp messageService ;

	@Secured({"ROLE_ADMIN"})
	@PostMapping("/mensaje")
	public void mensaje(@RequestBody PromotionEntity promotionEntity) {
		String nombre = promotionEntity.getName();
		String descripcion = promotionEntity.getDescription();
		String descuento = promotionEntity.getPercent();
		messageService.promotion(nombre,descripcion, descuento );
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/list")
	public List<PromotionEntity> findAll() {
		return promotionService.findAll();
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/list/{id}")
	public PromotionEntity findById(@PathVariable Long id) {
		return promotionService.findById(id);
	}

	@Secured({"ROLE_ADMIN"})
	@PostMapping("/list")
	public PromotionEntity save(@RequestBody PromotionEntity promotionEntity) {
		return promotionService.save(promotionEntity);
	}

	@Secured({"ROLE_ADMIN"})
	@PutMapping("/list/{id}")
	public PromotionEntity update(@RequestBody PromotionEntity promotionEntity, @PathVariable Long id) {

	
		PromotionEntity promotionDataBase = promotionService.findById(id);
		promotionDataBase.setName(promotionEntity.getName());
		promotionDataBase.setDescription(promotionEntity.getDescription());
		promotionDataBase.setInitialDate(promotionEntity.getInitialDate());
		promotionDataBase.setEndDate(promotionEntity.getEndDate());

		return promotionService.save(promotionDataBase);
	}

	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("list/{id}")
	public void delete(@PathVariable Long id) {
		promotionService.delete(id);
	}

}
