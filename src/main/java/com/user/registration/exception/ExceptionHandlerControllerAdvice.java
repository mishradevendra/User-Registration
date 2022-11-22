package com.user.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleResourceNotFound(ResourceNotFoundException exception, WebRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(new Date());
		error.setMessage(exception.getMessage());
		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse globalExceptionHandler(Exception exception, WebRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(new Date());
		error.setMessage(exception.getMessage());
		return error;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

		/*ExceptionResponse error = new ExceptionResponse();
		ex.getBindingResult().getFieldErrors().forEach(error ->
		{
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(new Date());
		error.setMessage(ex.getDefaultMessage());
		});
		return error;*/

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
				errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
}