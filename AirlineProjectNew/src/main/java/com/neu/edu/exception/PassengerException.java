package com.neu.edu.exception;

public class PassengerException extends Exception {

	public PassengerException(String message)
	{
		super("PassengerException-"+message);
	}
	
	public PassengerException(String message, Throwable cause)
	{
		super("PassengerException-"+message,cause);
	}
}
