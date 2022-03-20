package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	public ResponseEntity<ErrorMessage> handleException(ErrorMessage errorMessage)
	{
		return ResponseEntity.status(errorMessage.getStatus()).header("ERROR_MESSAGE", errorMessage.getMessage()).build();
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity< ErrorMessage> notFoundException(NotFoundException exception,WebRequest request) {
		
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return handleException(message);
	}
	@ExceptionHandler(ConficlitException.class)
	public ResponseEntity< ErrorMessage> conflicitException(ConficlitException exception,WebRequest request) {
		
		ErrorMessage message=new ErrorMessage(HttpStatus.CONFLICT,exception.getMessage());
		return handleException(message);
	}
}
