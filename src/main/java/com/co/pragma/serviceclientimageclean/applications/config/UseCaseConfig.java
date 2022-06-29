package com.co.pragma.serviceclientimageclean.applications.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.pragma.serviceclientimageclean.domain.model.gateways.ImageRepository;
import com.co.pragma.serviceclientimageclean.domain.usecase.ImageUseCase;

@Configuration
public class UseCaseConfig {
	
	@Bean
	ImageUseCase getImageUseCase(ImageRepository imageRepository) {
		return new ImageUseCase(imageRepository);
	}

}
