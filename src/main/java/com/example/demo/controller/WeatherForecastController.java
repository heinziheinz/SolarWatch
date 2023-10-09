package com.example.demo.controller;

import com.example.demo.model.CityName;
import com.example.demo.model.WeatherReport;
import com.example.demo.service.OpenWeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
public class WeatherForecastController {

    private static final String[] summaries = {
            "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };
    private final OpenWeatherService openWeatherService;
    private final Random random = new Random();

    public WeatherForecastController(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }


    @GetMapping("/sunrise-sunset")
    public CityName getSunrise(@RequestParam(defaultValue = "1586468027") long timestamp, @RequestParam(defaultValue = "Vienna") String city) {
        System.out.println("timestamp = " + timestamp);
        System.out.println("City = " + city);
        return openWeatherService.getCurrentWeatherForBudapest(timestamp, city);
    }

}