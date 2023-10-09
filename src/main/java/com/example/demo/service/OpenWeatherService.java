package com.example.demo.service;

import com.example.demo.model.CityName;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;

@Service
public class OpenWeatherService {


    private static final String API_KEY = "46173ad2864741a38ea0ae7d137abca3";

    private final RestTemplate restTemplate;

    public OpenWeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CityName getCurrentWeatherForBudapest(long dt, String name) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&dt=%s",name,API_KEY, dt);

        CityName response = restTemplate.getForObject(url, CityName.class);

        assert response != null;
        return new CityName(
                response.name(),
                response.sys()
        );
    }
}
