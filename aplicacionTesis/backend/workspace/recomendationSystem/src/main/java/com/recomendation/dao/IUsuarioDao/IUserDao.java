package com.recomendation.dao.IUsuarioDao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.recomendation.entity.user.UserEntity;

public interface IUserDao extends CrudRepository<UserEntity, Long>{
	
	public UserEntity findByName(String name);


}
