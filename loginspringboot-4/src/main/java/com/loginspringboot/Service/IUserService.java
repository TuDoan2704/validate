package com.loginspringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loginspringboot.Entity.UserEntity;
@Service
public interface IUserService {
	
	void deleteAll();

	void deleteAll(List<UserEntity> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(UserEntity entity);

	void deleteById(Long id);

	long count();

	List<UserEntity> findAllById(List<Long> ids);

	List<UserEntity> findAll();

	boolean existsById(Long id);

	Optional<UserEntity> findById(Long id);

	List<UserEntity> saveAll(List<UserEntity> entities);

	UserEntity save(UserEntity entity);

	UserEntity findOneByUserName(String username);

}
