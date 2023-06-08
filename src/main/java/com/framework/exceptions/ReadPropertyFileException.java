package com.framework.exceptions;

@SuppressWarnings("serial")
public class ReadPropertyFileException extends FrameworkException{

	
	public ReadPropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }
	

	public ReadPropertyFileException(String message) {
        super(message);
    }
	
}
