package com.gaoshuhang.sm.exception;

public class StateNotRegisteredException extends RuntimeException
{
	public StateNotRegisteredException()
	{
		super();
	}

	public StateNotRegisteredException(String message)
	{
		super(message);
	}
}
