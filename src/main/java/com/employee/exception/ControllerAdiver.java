package com.employee.exception;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ControllerAdiver {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> alreadyEmployeeCreated(EmployeeException message) {
		return new ResponseEntity<String>(message.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> employeeIdNotAvaialbe(NoSuchElementException message){
		return new ResponseEntity<String>(message.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> MethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		  // Collect the validation error messages directly
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage()) // Get only the custom message
                .collect(Collectors.toList());
		return new ResponseEntity<String>(errors.get(0), HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<String> NoResourceFoundException(NoResourceFoundException  ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
}
