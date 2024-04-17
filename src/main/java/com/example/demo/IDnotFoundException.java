package com.example.demo;

public class IDnotFoundException extends RuntimeException {

	public IDnotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public IDnotFoundException(String message) {
		super(message);
	}

	public IDnotFoundException(Throwable cause) {
		super(cause);
	}
	
}
