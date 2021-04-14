package com.capgemini.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ EmployeeNotFoundException.class })
	public final ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest rq) {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(),
				"The user which you are trying to fetch is not in the system", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ EmployeeExistsException.class })
	public final ResponseEntity<Object> handleEmployeeExistsException(EmployeeNotFoundException ex, WebRequest rq) {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(),
				"The user which you are trying to add is already present", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(), "Something went wrong!", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
