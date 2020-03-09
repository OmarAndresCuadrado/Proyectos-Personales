package com.serviguadanas.backend.services.user;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviguadanas.backend.dao.user.IUserDao;
import com.serviguadanas.backend.entity.user.UserEntity;



@Service
public class UserService implements IUserService, UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity usuario = userDao.findByName(username);
		
		if(usuario == null) {
			logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getName(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public UserEntity findByName(String username) {
		return userDao.findByName(username);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserEntity> findAll() {
		return (List<UserEntity>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public UserEntity findById(Long id) {
		return userDao.findById(id).orElse(null);
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		return userDao.save(userEntity);
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);

	}
}
