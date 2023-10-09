package com.example.demo.model;

import java.time.LocalDate;

public record WeatherReport(LocalDate date, int temperatureC, String summary, String city) { }