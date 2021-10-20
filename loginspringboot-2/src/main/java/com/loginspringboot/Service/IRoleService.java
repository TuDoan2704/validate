package com.loginspringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loginspringboot.Entity.RoleEntity;

@Service
public interface IRoleService {

	void deleteAll();

	void deleteAll(List<RoleEntity> entities);

	void deleteAllById(List<String> ids);

	void delete(RoleEntity entity);

	void deleteById(String id);

	long count();

	List<RoleEntity> findAllById(List<String> ids);

	List<RoleEntity> findAll();

	boolean existsById(String id);

	Optional<RoleEntity> findById(String id);

	List<RoleEntity> saveAll(List<RoleEntity> entities);

	RoleEntity save(RoleEntity entity);

}
