package com.jhl.ipaiemanager.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends HttpException {
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super(HttpStatus.NOT_FOUND.getReasonPhrase());
    }
	
	public ResourceNotFoundException(String message, long id) {
        super(String.format(message, id));
    }

    public ResourceNotFoundException(String resource, String message) {
        super(resource, message);
    }
    
    public ResourceNotFoundException(String resource, String message, Throwable cause) {
		super(resource, message, cause);
	}
	
}
