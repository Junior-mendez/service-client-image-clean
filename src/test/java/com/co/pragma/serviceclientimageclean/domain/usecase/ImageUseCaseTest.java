package com.co.pragma.serviceclientimageclean.domain.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageCreatedException;
import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageNotFoundException;
import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageUpdateException;
import com.co.pragma.serviceclientimageclean.domain.model.gateways.ImageRepository;
import com.co.pragma.serviceclientimageclean.helpers.ImageHelper;

@ExtendWith(MockitoExtension.class)
class ImageUseCaseTest {

	@Mock
	private ImageRepository imageRepository;
	
	
	@InjectMocks
	private ImageUseCase imageUseCase;

	@Test
	void testCreateClientImage() {
		when(imageRepository.create(Mockito.any())).thenReturn(ImageHelper.createImage());
		
		assertEquals("DNI76515669",imageUseCase.create(ImageHelper.createImage()).getId());
	}
	
	@Test
	void testCreateClientImageException() {
		when(imageRepository.create(Mockito.any())).thenReturn(null);
		
		assertThrows(ClientImageCreatedException.class,
				()->{imageUseCase.create(ImageHelper.createImage());});
	}
	
	@Test
	void testUpdateClientImage() {
		when(imageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(imageRepository.update(Mockito.any())).thenReturn(ImageHelper.createImage());
		
		assertEquals("DNI76515669",imageUseCase.update(ImageHelper.createImage()).getId());
	}
	
	@Test
	void testUpdateClientImageException() {
		when(imageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(imageRepository.update(Mockito.any())).thenReturn(null);
		
		assertThrows(ClientImageUpdateException.class,
				()->{imageUseCase.update(ImageHelper.createImage());});
	}
	@Test
	void testUpdateClientImageNotFoundException() {
		when(imageRepository.existsImage(Mockito.any())).thenReturn(false);
		
		assertThrows(ClientImageNotFoundException.class,
				()->{imageUseCase.update(ImageHelper.createImage());});
	}
	
	@Test
	void testGetClientImage() {
		when(imageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(imageRepository.getImage(Mockito.anyString())).thenReturn(Optional.of(ImageHelper.createImage()));
		
		assertEquals("DNI76515669",imageUseCase.getImage("DNI76515669").getId());
	}
	@Test
	void testGetClientImageNotFoundException() {
		when(imageRepository.existsImage(Mockito.any())).thenReturn(false);
		
		assertThrows(ClientImageNotFoundException.class,
				()->{imageUseCase.getImage("DNI76515669");});
	}
	@Test
	void testGetClientImageException() {
		when(imageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(imageRepository.getImage(Mockito.anyString())).thenReturn(null);
		assertThrows(NullPointerException.class,
				()->{imageUseCase.getImage("DNI76515669");});
	}

}
