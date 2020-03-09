package com.serviguadanas.backend.controller.user;

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

import com.serviguadanas.backend.entity.user.UserEntity;
import com.serviguadanas.backend.services.user.IUserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/list")
	public List<UserEntity> findAll() {
		return userService.findAll();
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/list/{id}")	
	public UserEntity findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
//	@Secured({"ROLE_ADMIN"})
	@PostMapping("/register")
	public UserEntity save(@RequestBody  UserEntity userEntity) {
		return userService.save(userEntity);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/list/{id}")
	public UserEntity update(@RequestBody UserEntity userEntity, @PathVariable Long id) {
		
		
		UserEntity usuarioDataBase = userService.findById(id);
		usuarioDataBase.setName(userEntity.getName());
		usuarioDataBase.setPhone(userEntity.getPhone());
		
		return userService.save(usuarioDataBase);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("list/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}

}
