package com.enrolee.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EnroleeException extends RuntimeException{
	
	private static final long serialVersionUID = -1809069826752557868L;
	public EnroleeException(String message, Throwable t) {
		super(message, t);
	}

	public EnroleeException(String message) {
		super(message);
	}
}
