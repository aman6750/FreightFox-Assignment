package com.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Information {

	private String temp;
	private String feels_like;
	private String temp_min;
	private String temp_max;
	private String pressure;
	private String humidity;
	private String sea_level;
	private String grnd_level;
}
