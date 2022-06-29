package com.co.pragma.serviceclientimageclean.infraestructure.driveradapters.mappers;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.co.pragma.serviceclientimageclean.domain.model.Image;
import com.co.pragma.serviceclientimageclean.infraestructure.driveradapters.mongo.ImageEntity;

@Mapper(componentModel = "spring")
public interface ImageMapper {

	@Mapping(source = "image.imageContent", target = "image")
	ImageEntity imageDomainToImageEntity(Image image);

	@Mapping(source = "imageEntity.image", target = "imageContent")
	Image imageEntitytoImageDomain(ImageEntity imageEntity);

}
