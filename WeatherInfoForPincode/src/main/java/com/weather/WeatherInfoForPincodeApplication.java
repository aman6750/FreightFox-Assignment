package com.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Weather-Api", version = "1.1"))
public class WeatherInfoForPincodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherInfoForPincodeApplication.class, args);
	}

}
