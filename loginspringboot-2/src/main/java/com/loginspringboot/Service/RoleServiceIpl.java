package com.loginspringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginspringboot.Entity.RoleEntity;
import com.loginspringboot.Repository.RoleRepository;
@Service
public class RoleServiceIpl implements IRoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public RoleEntity save(RoleEntity entity) {
		return roleRepository.save(entity);
	}

	@Override
	public List<RoleEntity> saveAll(List<RoleEntity> entities) {
		return (List<RoleEntity>) roleRepository.saveAll(entities);
	}

	@Override
	public Optional<RoleEntity> findById(String id) {
		return roleRepository.findById(id);
	}
	
	@Override
	public boolean existsById(String id) {
		return roleRepository.existsById(id);
	}

	@Override
	public List<RoleEntity> findAll() {
		return (List<RoleEntity>) roleRepository.findAll();
	}

	@Override
	public List<RoleEntity> findAllById(List<String> ids) {
		return (List<RoleEntity>) roleRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return roleRepository.count();
	}

	@Override
	public void deleteById(String id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void delete(RoleEntity entity) {
		roleRepository.delete(entity);
	}

	@Override
	public void deleteAllById(List<String> ids) {
		roleRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<RoleEntity> entities) {
		roleRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		roleRepository.deleteAll();
	}
	
}
