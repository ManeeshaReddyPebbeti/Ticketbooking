package com.manu.threadhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppThreadconfig {
	@ExceptionHandler(value = TicketException.class)
	public ResponseEntity<Threadbean> handleEmployeeException(TicketException ee){
		String message = ee.getMessage();
		Threadbean eb = new Threadbean();
		eb.setCode("EXCPTIONISGGD000");
		eb.setMsg(message);
		return new ResponseEntity<>(eb, HttpStatus.BAD_REQUEST);
	}

}
