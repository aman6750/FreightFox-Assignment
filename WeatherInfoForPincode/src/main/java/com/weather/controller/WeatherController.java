package com.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weather.model.Description;
import com.weather.service.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService service;

	@GetMapping("/getAllinfo/{inputData}")
	public ResponseEntity<Description> getAllData(@PathVariable ("inputData") String inputData) {
		
		return new ResponseEntity<Description>(service.getAllData(inputData),HttpStatus.OK);
				
	}
	
}
