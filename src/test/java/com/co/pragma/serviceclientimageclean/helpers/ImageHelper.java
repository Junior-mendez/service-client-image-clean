package com.co.pragma.serviceclientimageclean.helpers;

import com.co.pragma.serviceclientimageclean.domain.model.Image;
import com.co.pragma.serviceclientimageclean.infraestructure.driveradapters.mongo.ImageEntity;
import com.co.pragma.serviceclientimageclean.infraestructure.entrypoints.api.models.ImageRequest;

public class ImageHelper {
	public static ImageRequest createImageRequest() {
		return new ImageRequest("DNI76515669","DSDSFDSFSDF");
	}
	public static Image createImage() {
		return new Image("DNI76515669","DSDSFDSFSDF");
	}
	
	public static ImageEntity createImageEntity() {
		return new ImageEntity("DNI76515669","DSDSFDSFSDF");
	}
}
