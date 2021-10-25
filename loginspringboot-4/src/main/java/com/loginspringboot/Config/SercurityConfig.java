package com.loginspringboot.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity

public class SercurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailService;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http.authorizeRequests()
		.antMatchers("/css/**","/image/**").permitAll();
		
		http.authorizeRequests()
		.antMatchers("information/list").hasAnyAuthority("user", "admin");
		
		http.authorizeRequests()
		.antMatchers("/information/sua/**").hasAuthority("admin")
		.antMatchers("/information/delete/**").hasAuthority("admin");
		
		http.authorizeRequests()
		.and().exceptionHandling().accessDeniedPage("/information/404");
		
		http.authorizeRequests()
		.anyRequest().authenticated().and()
		.formLogin().loginPage("/home").permitAll()
		.defaultSuccessUrl("/information/list")
		.failureUrl("/information/excep")
		.loginProcessingUrl("/j_spring_security_check")
		.and().logout().permitAll();
		
		http.authorizeRequests().and() 
		.rememberMe().tokenRepository(this.persistentTokenRepository()) 
		.tokenValiditySeconds(1 * 24 * 60 * 60); 
		
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
	    InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
	    return memory;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
		
	}

}
