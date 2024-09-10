package com.pack.customException;

public class NoSuchClassFoundException extends RuntimeException
{
	private static final long serialVersionUID = 5957581746421273704L;

	public NoSuchClassFoundException(String message) 
	{
		super(message);
	}
}
