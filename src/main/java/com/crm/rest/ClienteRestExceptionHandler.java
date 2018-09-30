package com.crm.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.crm.entity.ClienteErrorResponse;
import com.crm.entity.ClienteNotFoundException;

@ControllerAdvice
public class ClienteRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ClienteErrorResponse> handleException(Exception e){
		
		
		if(e instanceof ClienteNotFoundException) {
			//ClienteNotFoundException
			ClienteErrorResponse errorResponse= new ClienteErrorResponse().builder()
													.status(HttpStatus.NOT_FOUND.value())
													.mensaje(e.getMessage())
													.timestamp(System.currentTimeMillis())
													.build();
			
			return new ResponseEntity<ClienteErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
		}
		
		//Exception
		ClienteErrorResponse errorResponse= new ClienteErrorResponse().builder()
													.status(HttpStatus.BAD_REQUEST.value())
													.mensaje(e.getMessage())
													.timestamp(System.currentTimeMillis())
													.build();
			
		return new ResponseEntity<ClienteErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
