package com.co.pragma.serviceclientimageclean.infraestructure.driveradapters.mongo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.pragma.serviceclientimageclean.domain.model.Image;
import com.co.pragma.serviceclientimageclean.domain.model.gateways.ImageRepository;
import com.co.pragma.serviceclientimageclean.infraestructure.driveradapters.mappers.ImageMapper;

@Component
public class MongoDBDataRepositoryImpl implements ImageRepository {
	
	
	@Autowired
	private MongoDataRepository mongoDataRepository;
	
	@Autowired
	private ImageMapper imageMapper;

	@Override
	public Image create(Image image) {
		return imageMapper.imageEntitytoImageDomain(mongoDataRepository.insert(imageMapper.imageDomainToImageEntity(image))) ;
	}

	@Override
	public Boolean existsImage(String id) {
		return mongoDataRepository.existsById(id);
	}

	@Override
	public Image update(Image image) {
		return imageMapper.imageEntitytoImageDomain(mongoDataRepository.save(imageMapper.imageDomainToImageEntity(image))) ;
	}

	@Override
	public Optional<Image> getImage(String id) {
		return mongoDataRepository.findById(id)
				.map(imageMapper::imageEntitytoImageDomain);
	}

}
