package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		
        super();
        System.out.println("ResourceNotFoundException no msg");
    }

    public ResourceNotFoundException(String message) {
    	
        super(message);
        System.out.println("ResourceNotFoundException "+message );
    }

    public ResourceNotFoundException(String message, Throwable cause) {
    	
        super(message, cause);
        System.out.println("ResourceNotFoundException "+message+" "+cause);
    }
}
