package com.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Description {

	private String timezone;
	private String name;
	private Information main;
	private Weather[] weather;
	private String visibility;
	private Cordination coord;
	private Location sys;
	
	
}
