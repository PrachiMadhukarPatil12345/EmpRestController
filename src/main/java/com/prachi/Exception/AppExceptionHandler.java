package com.prachi.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppExceptionHandler
{
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception e)
	{
		ErrorResponse response = new ErrorResponse();
		response.setMsg(e.getMessage());
		response.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

