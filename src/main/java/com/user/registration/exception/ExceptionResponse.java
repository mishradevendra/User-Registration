package com.user.registration.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {

	  private int statusCode;
	  private Date timestamp;
	  private String message;
}