
package com.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cordination {

	
	private String lon;
	private String lat;
	
	
}
