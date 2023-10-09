package com.example.demo.controller;

import com.example.demo.model.CityName;
import com.example.demo.model.OptionalGetLatLong;
import com.example.demo.model.SunUpSunDown;
import com.example.demo.service.OpenWeatherGetCoordinatesForCity;
import com.example.demo.service.OpenWeatherService;
import com.example.demo.service.SunriseSunset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WeatherForecastController {

    private static final String[] summaries = {
            "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };
    private final OpenWeatherService openWeatherService;
    private final Random random = new Random();
    private final OpenWeatherGetCoordinatesForCity openWeatherGetCoordinatesForCity;

    private final SunriseSunset sunriseSunset;

    public WeatherForecastController(OpenWeatherService openWeatherService, OpenWeatherGetCoordinatesForCity openWeatherGetCoordinatesForCity, SunriseSunset sunriseSunset) {
        this.openWeatherService = openWeatherService;
        this.openWeatherGetCoordinatesForCity = openWeatherGetCoordinatesForCity;
        this.sunriseSunset = sunriseSunset;
    }


    @GetMapping("/sunrise-sunset")
    public CityName getSunrise(@RequestParam(defaultValue = "1586468027") long timestamp, @RequestParam(defaultValue = "Vienna") String city) {
        System.out.println("timestamp = " + timestamp);
        System.out.println("City = " + city);
        return openWeatherService.getCurrentWeatherForBudapest(timestamp, city);
    }

    @GetMapping("/optional-get-sunrise-sunset")
    public SunUpSunDown getOptionalSunriseOrSunset(@RequestParam String cityName) {
        System.out.println("cityName = " + cityName);
        OptionalGetLatLong optionalGetLatLong =  openWeatherGetCoordinatesForCity.getCoordinatesForCityName(cityName);
        return sunriseSunset.getSunsetUndSunrise(optionalGetLatLong);
    }
}