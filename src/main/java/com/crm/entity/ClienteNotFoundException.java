package com.crm.entity;

public class ClienteNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNotFoundException(String mensaje) {
		super(mensaje);
	}
}
