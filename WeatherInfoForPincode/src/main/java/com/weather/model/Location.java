package com.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	private String country;
	private String sunrise;
	private String sunset;
	
}
