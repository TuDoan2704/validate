package com.loginspringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginspringboot.Entity.UserEntity;
import com.loginspringboot.Repository.UserRepository;

@Service
public class UserServiceIpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity findOneByUserName(String username) {
		return userRepository.findOneByUserName(username);
	}
	
	@Override
	public UserEntity save(UserEntity entity) {
		return userRepository.save(entity);
	}

	@Override
	public List<UserEntity> saveAll(List<UserEntity> entities) {
		return (List<UserEntity>) userRepository.saveAll(entities);
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public List<UserEntity> findAll() {
		return  (List<UserEntity>) userRepository.findAll();
	}

	@Override
	public List<UserEntity> findAllById(List<Long> ids) {
		return (List<UserEntity>) userRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(UserEntity entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		userRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<UserEntity> entities) {
		userRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
