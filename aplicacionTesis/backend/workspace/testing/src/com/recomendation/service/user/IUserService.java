package com.recomendation.service.user;

import com.recomendation.entity.user.UserEntity;

public interface IUserService {

	public UserEntity findByName(String name);
}
