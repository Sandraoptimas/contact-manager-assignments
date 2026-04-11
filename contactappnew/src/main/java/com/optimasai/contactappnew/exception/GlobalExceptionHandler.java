package com.optimasai.contactappnew.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody   
	public Map<String, Object> handleNotFound(ResourceNotFoundException ex) {

	    Map<String, Object> error = new HashMap<>();
	    error.put("message", ex.getMessage());
	    error.put("status", 404);

	    return error;
	}
}