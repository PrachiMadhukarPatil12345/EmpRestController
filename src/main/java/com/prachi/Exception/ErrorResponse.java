package com.prachi.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse 
{
	String msg;
	
	LocalDateTime dateTime;
}
