package com.loginspringboot.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loginspringboot.Entity.UserEntity;

@Repository

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findOneByUserName(String username);

}
