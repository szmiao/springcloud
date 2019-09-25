package com.common.exception;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 3583566093089790852L;

	private Integer code;

	public ServiceException(String message) {
		super(message);
		this.code=500;
	}
}
