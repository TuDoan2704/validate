package com.loginspringboot.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loginspringboot.Entity.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, String>  {

}
