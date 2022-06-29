package com.co.pragma.serviceclientimageclean.domain.usecase;

import java.util.Optional;

import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageCreatedException;
import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageNotFoundException;
import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageUpdateException;
import com.co.pragma.serviceclientimageclean.domain.model.Image;
import com.co.pragma.serviceclientimageclean.domain.model.gateways.ImageRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ImageUseCase {
	
	private final ImageRepository imageRepository;
	
	public Image create(Image image) {
		return Optional.ofNullable(imageRepository
				.create(image))
				.orElseThrow(()->new ClientImageCreatedException(image));
	}

	
	public Image update(Image image) {
		if(Boolean.FALSE.equals(imageRepository.existsImage(image.getId()))) {
			throw new ClientImageNotFoundException(image.getId());
		}
		return Optional.ofNullable(imageRepository
				.update(image))
				.orElseThrow(()->new ClientImageUpdateException(image.getId()));
	}

	
	public Image getImage(String id) {
		if(Boolean.FALSE.equals(imageRepository.existsImage(id))) {
			throw new ClientImageNotFoundException(id);
		}

		return imageRepository.getImage(id)
				.orElseThrow(NullPointerException::new);
	}

}
