package com.serviguadanas.backend.controller.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviguadanas.backend.entity.business.BusinessEntity;
import com.serviguadanas.backend.services.business.IBusinessService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private IBusinessService businessService;

	@GetMapping("/list")
	public List<BusinessEntity> findAll() {
		return businessService.findAll();
	}

	@GetMapping("/list/{id}")
	public BusinessEntity findById(@PathVariable Long id) {
		return businessService.findById(id);
	}

	@PostMapping("/list")
	public BusinessEntity save(@RequestBody BusinessEntity BusinessEntity) {
		return businessService.save(BusinessEntity);
	}

	@PutMapping("/list/{id}")
	public BusinessEntity update(@RequestBody BusinessEntity BusinessEntity, @PathVariable Long id) {

		BusinessEntity userUpdate = null;
		BusinessEntity usuarioDataBase = businessService.findById(id);
		usuarioDataBase.setName(BusinessEntity.getName());
		usuarioDataBase.setPhone(BusinessEntity.getPhone());

		return userUpdate = businessService.save(usuarioDataBase);
	}

	@DeleteMapping("list/{id}")
	public void delete(@PathVariable Long id) {
		businessService.delete(id);
	}

}
