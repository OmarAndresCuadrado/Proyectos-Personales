package com.serviguadanas.backend.controller.product;

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

import com.serviguadanas.backend.entity.product.ProductEntity;
import com.serviguadanas.backend.services.product.IProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/list")
	public List<ProductEntity> findAll() {
		return productService.findAll();
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/list/{id}")
	public ProductEntity findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@Secured({"ROLE_ADMIN"})
	@PostMapping("/list")
	public ProductEntity save(@RequestBody ProductEntity productEntity) {
		return productService.save(productEntity);
	}

	@Secured({"ROLE_ADMIN"})
	@PutMapping("/list/{id}")
	public ProductEntity update(@RequestBody ProductEntity productEntity, @PathVariable Long id) {

		ProductEntity productDataBase = productService.findById(id);
		productDataBase.setName(productEntity.getName());
		productDataBase.setCost(productEntity.getCost());
		productDataBase.setDescription(productEntity.getDescription());
		productDataBase.setMachinebrand(productEntity.getMachinebrand());
		productDataBase.setType(productEntity.getType());

		return productService.save(productDataBase);
	}

	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("list/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}

}
