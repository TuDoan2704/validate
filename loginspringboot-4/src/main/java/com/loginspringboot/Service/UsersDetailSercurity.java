package com.loginspringboot.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loginspringboot.Entity.RoleEntity;
import com.loginspringboot.Entity.UserEntity;
import com.loginspringboot.Repository.UserRepository;

@Service
public class UsersDetailSercurity implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = this.userRepository.findOneByUserName(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		UserDetails userDetails = (UserDetails) new User(userEntity.getUserName(), 
        		userEntity.getPassword(), authorities );
		return userDetails;
   }
	
}
