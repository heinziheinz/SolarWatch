package com.example.demo.controller;

import com.example.demo.configuration.RestTemplateConfiguration;
import com.example.demo.service.OpenWeatherGetCoordinatesForCity;
import com.example.demo.service.OpenWeatherService;
import com.example.demo.service.SunriseSunset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(classes = {RestTemplateConfiguration.class, WeatherForecastController.class})
@SpringBootTest
class WeatherForecastControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    private WeatherForecastController weatherForecastController;

    @BeforeEach
    public void setup() {

        OpenWeatherService openWeatherService = new OpenWeatherService(restTemplate);
        OpenWeatherGetCoordinatesForCity openWeatherGetCoordinatesForCity = new OpenWeatherGetCoordinatesForCity(restTemplate);
        SunriseSunset sunriseSunset = new SunriseSunset(restTemplate);

        weatherForecastController = new WeatherForecastController(openWeatherService, openWeatherGetCoordinatesForCity, sunriseSunset);
    }



    @Test
    void getSunrise() {
    }

    @Test
    void getOptionalSunriseOrSunset() {
    }
}