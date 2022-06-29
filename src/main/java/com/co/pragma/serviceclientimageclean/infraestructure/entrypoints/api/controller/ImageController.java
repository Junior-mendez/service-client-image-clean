package com.co.pragma.serviceclientimageclean.infraestructure.entrypoints.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.pragma.serviceclientimageclean.domain.model.Image;
import com.co.pragma.serviceclientimageclean.domain.usecase.ImageUseCase;
import com.co.pragma.serviceclientimageclean.infraestructure.entrypoints.api.models.ImageRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/image", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ImageController {
	
	private final ImageUseCase imageUseCase;
	
	@PostMapping(value = "/create"
			,consumes  = {MediaType.APPLICATION_JSON_VALUE}
			,produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(
		      value = "Insert image of client",
		      nickname = "Insert image of client",
		      response = Image.class)
	@ApiResponses(
		      value = {
		        @ApiResponse(code = 200, message = "Success"),
		        @ApiResponse(code = 400, message = "Bad Request"),
		        @ApiResponse(code = 403, message = "Forbidden"),
		        @ApiResponse(code = 404, message = "Not Found"),
		        @ApiResponse(code = 500, message = "Failure")
		      })
	public ResponseEntity<Image> create(@RequestBody ImageRequest clientImage) {
		
	     return new ResponseEntity<>(imageUseCase.create(Image.builder()
	    		 .id(clientImage.getId()).imageContent(clientImage.getImage()).build()),HttpStatus.OK);
	}
	
	@PostMapping(value = "/update"
			,consumes  = {MediaType.APPLICATION_JSON_VALUE}
			,produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(
		      value = "Update image of client",
		      nickname = "Update image of client",
		      response = Image.class)
	@ApiResponses(
		      value = {
		        @ApiResponse(code = 200, message = "Success"),
		        @ApiResponse(code = 400, message = "Bad Request"),
		        @ApiResponse(code = 403, message = "Forbidden"),
		        @ApiResponse(code = 404, message = "Not Found"),
		        @ApiResponse(code = 500, message = "Failure")
		      })
	public ResponseEntity<Image> update(@RequestBody ImageRequest clientImage) {
		 
	     return new ResponseEntity<>(imageUseCase.update(Image.builder()
	    		 .id(clientImage.getId()).imageContent(clientImage.getImage()).build()),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}"
				,produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(
		      value = "Get image of client",
		      nickname = "Get image of client",
		      response = Image.class)
	@ApiResponses(
		      value = {
		        @ApiResponse(code = 200, message = "Success"),
		        @ApiResponse(code = 400, message = "Bad Request"),
		        @ApiResponse(code = 403, message = "Forbidden"),
		        @ApiResponse(code = 404, message = "Not Found"),
		        @ApiResponse(code = 500, message = "Failure")
		      })
	public ResponseEntity<Image> getImage(@PathVariable(name = "id") String id)  {
		 
	     return new ResponseEntity<>(imageUseCase.getImage(id),HttpStatus.OK);
	}

}
