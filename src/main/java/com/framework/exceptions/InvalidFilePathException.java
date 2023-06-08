package com.framework.exceptions;

@SuppressWarnings("serial")
public class InvalidFilePathException extends FrameworkException{

	
	public InvalidFilePathException(String message, Throwable cause) {
        super(message,cause);
    }
	
	public InvalidFilePathException(String message) {
        super(message);
    }
	
}
