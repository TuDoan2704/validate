package com.loginspringboot.API;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String emptyResult(Exception ex) {
		ex.printStackTrace();
		return "excep";
	}
	
}
