package com.co.pragma.serviceclientimageclean.domain.model.gateways;

import java.util.Optional;

import com.co.pragma.serviceclientimageclean.domain.model.Image;


public interface ImageRepository {
	
	Image create(Image image);
		
	Boolean existsImage(String id);
		
	Image update(Image image);
		
	Optional<Image> getImage(String id);

}
