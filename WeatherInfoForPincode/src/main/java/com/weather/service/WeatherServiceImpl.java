package com.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.model.Description;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	private final RestTemplate restTemplate;

	@Autowired
	public WeatherServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Description getAllData(String stateCode) {
		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?zip="+ stateCode +",in&appid=df7d9d47d309d446f5ab57a58f5e2e79", Description.class);

	}

}
