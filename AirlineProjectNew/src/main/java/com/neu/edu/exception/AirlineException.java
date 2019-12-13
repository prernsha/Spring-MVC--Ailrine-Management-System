package com.neu.edu.exception;

public class AirlineException extends Exception {

	public AirlineException(String message)
	{
		super("AirlineException-"+message);
	}
	
	public AirlineException(String message, Throwable cause)
	{
		super("AirlineException-"+message,cause);
	}
	
}
