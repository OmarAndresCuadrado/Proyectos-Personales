package com.serviguadanas.backend.controller.business;

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

import com.serviguadanas.backend.entity.business.BusinessEntity;
import com.serviguadanas.backend.services.business.IBusinessService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private IBusinessService businessService;

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/list")
	public List<BusinessEntity> findAll() {
		return businessService.findAll();
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/list/{id}")
	public BusinessEntity findById(@PathVariable Long id) {
		return businessService.findById(id);
	}

	@Secured({"ROLE_ADMIN"})
	@PostMapping("/list")
	public BusinessEntity save(@RequestBody BusinessEntity businessEntity) {
		return businessService.save(businessEntity);
	}

	@Secured({"ROLE_ADMIN"})
	@PutMapping("/list/{id}")
	public BusinessEntity update(@RequestBody BusinessEntity businessEntity, @PathVariable Long id) {

		BusinessEntity businessDataBase = businessService.findById(id);
		businessDataBase.setName(businessEntity.getName());
		businessDataBase.setPhone(businessEntity.getPhone());
		businessDataBase.setSchedule(businessEntity.getSchedule());

		return businessService.save(businessDataBase);
	}

	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("list/{id}")
	public void delete(@PathVariable Long id) {
		businessService.delete(id);
	}

}
