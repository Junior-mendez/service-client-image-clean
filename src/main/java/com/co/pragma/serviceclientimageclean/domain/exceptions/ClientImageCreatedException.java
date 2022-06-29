package com.co.pragma.serviceclientimageclean.domain.exceptions;

import com.co.pragma.serviceclientimageclean.domain.model.Image;

public class ClientImageCreatedException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8515033326580079609L;
	
	public ClientImageCreatedException (Image image) {
		super("Imagen no fue registrada".concat(image.toString()));
	}

}
