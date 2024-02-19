package com.javaspring.taskproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class APIException extends RuntimeException {
private String message;
public APIException(String message) {
	super(message);
	this.message=message;
}
public void APIException(String format) {
	// TODO Auto-generated constructor stub
}
}
