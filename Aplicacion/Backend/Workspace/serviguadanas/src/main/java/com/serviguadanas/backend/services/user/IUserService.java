package com.serviguadanas.backend.services.user;

import java.util.List;

import com.serviguadanas.backend.entity.user.UserEntity;

public interface IUserService {

	public UserEntity findByName(String name);

	public List<UserEntity> findAll();

	public UserEntity findById(Long id);

	public UserEntity save(UserEntity userEntity);

	public void delete(Long id);
}
