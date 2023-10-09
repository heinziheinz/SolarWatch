package com.example.demo.service;


import com.example.demo.model.OptionalGetLatLong;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OpenWeatherGetCoordinatesForCity {

    private static final String API_KEY = "46173ad2864741a38ea0ae7d137abca3";

    private final RestTemplate restTemplate;

    public OpenWeatherGetCoordinatesForCity(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OptionalGetLatLong getCoordinatesForCityName(String cityName) {
        System.out.println("cityName = " + cityName);
        String url = String.format("https://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s", cityName, API_KEY);

        List<OptionalGetLatLong> response = Arrays.asList(restTemplate.getForObject(url, OptionalGetLatLong[].class));


        return response.get(0);



    }
}
