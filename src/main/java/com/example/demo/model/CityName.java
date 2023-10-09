package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record CityName(String name, CitySunriseSunset sys) {
}
