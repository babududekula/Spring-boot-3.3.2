package com.pack.GlobalErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pack.customException.NoSuchClassFoundException;
import com.pack.errorClass.ErrorClass;

@RestControllerAdvice
public class GlobalController 
{
	@ExceptionHandler(value = {ArithmeticException.class})
	public ResponseEntity<ErrorClass> arithmeticException(ArithmeticException ae)
	{
		ErrorClass customer = new ErrorClass();
		customer.setErrorName(ae.getMessage());
		customer.setErrorCode("ERROR2345");
		
		return new ResponseEntity<ErrorClass>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<ErrorClass> nullPointerException(NullPointerException ne)
	{
		String message = ne.getMessage();
		String code = "NE-9097890";
		
		ErrorClass er = new ErrorClass();
		er.setErrorCode(code);
		er.setErrorName(message);
		
		return new ResponseEntity<ErrorClass>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NoSuchClassFoundException.class})
	public ResponseEntity<ErrorClass> noSuchClassFound(NoSuchClassFoundException nsfe)
	{
		String message = nsfe.getMessage();
		String code = "NSCFE-364674";
		
		ErrorClass ec = new ErrorClass();
		ec.setErrorName(message);
		ec.setErrorCode(code);
		
		return new ResponseEntity<ErrorClass>(ec, HttpStatus.BAD_REQUEST);
	}
}
