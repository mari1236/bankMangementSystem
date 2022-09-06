package com.example.demo.handleException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidateException(MethodArgumentNotValidException ex)
	{
		
		Map<String, String> error=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(err->
		{
			String field=((FieldError) err).getField();
			String errorMsg=err.getDefaultMessage();
			
			error.put(field, errorMsg);
		
		}
				);
		return error;
		
	}
}
