package com.co.pragma.serviceclientimageclean.infraestructure.entrypoints.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("image")
	private String image;

}
