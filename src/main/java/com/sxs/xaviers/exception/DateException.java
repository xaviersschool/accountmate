package com.sxs.xaviers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DateException extends Exception {

	private static final long serialVersionUID = 1L;

	public DateException(String message) {
		super(message);
	}
}