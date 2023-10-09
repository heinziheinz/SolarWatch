package com.example.demo.service;

import com.example.demo.model.CityName;
import com.example.demo.model.OptionalGetLatLong;
import com.example.demo.model.SunUpSunDown;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SunriseSunset {

    private static final String API_KEY = "46173ad2864741a38ea0ae7d137abca3";

    private final RestTemplate restTemplate;

    public SunriseSunset(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SunUpSunDown getSunsetUndSunrise(OptionalGetLatLong optionalGetLatLong){
        String url = String.format("https://api.sunrise-sunset.org/json?lat=%s&lng=%s",optionalGetLatLong.lat(), optionalGetLatLong.lon());

        SunUpSunDown response = restTemplate.getForObject(url, SunUpSunDown.class);

        assert response != null;
        return new SunUpSunDown(
                response.results()
        );
    }
}
