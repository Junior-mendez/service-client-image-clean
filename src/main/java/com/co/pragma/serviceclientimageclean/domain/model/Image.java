package com.co.pragma.serviceclientimageclean.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("image")
	private String imageContent;


}
