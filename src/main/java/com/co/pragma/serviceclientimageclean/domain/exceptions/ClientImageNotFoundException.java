package com.co.pragma.serviceclientimageclean.domain.exceptions;

public class ClientImageNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6281823993348877492L;
	
	public ClientImageNotFoundException(String id) {
		super ("Imagen de cliente con id: ".concat(id).concat(" no fue encontrado"));
	}

}
