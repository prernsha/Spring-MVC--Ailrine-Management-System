package com.neu.edu.exception;

public class FlightScheduleException extends Exception {

	public FlightScheduleException(String message)
	{
		super("FlightScheduleException-"+message);
	}
	
	public FlightScheduleException(String message, Throwable cause)
	{
		super("FlightScheduleException-"+message,cause);
	}
}
