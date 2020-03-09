package com.serviguadanas.backend.dao.user;

import org.springframework.data.repository.CrudRepository;

import com.serviguadanas.backend.entity.user.UserEntity;

public interface IUserDao extends CrudRepository<UserEntity, Long> {
	
	public UserEntity findByName(String name);


}
