package com.example.demo.controller;

import com.example.demo.model.WeatherReport;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final Random random = new Random();

    @GetMapping("/sunrise")
    public List<WeatherReport> getSunrise() {
        return Arrays.stream(IntStream.range(1, 6).toArray())
                .mapToObj(index ->
                        new WeatherReport(LocalDate.now().plusDays(index),
                                random.nextInt(-20, 55),
                                summaries[random.nextInt(summaries.length)],
                                "Sunrise")
                ).toList();
    }
    @GetMapping("/sunset")
    public List<WeatherReport> getSunset() {
        return Arrays.stream(IntStream.range(1, 6).toArray())
                .mapToObj(index ->
                        new WeatherReport(LocalDate.now().plusDays(index),
                                random.nextInt(-20, 55),
                                summaries[random.nextInt(summaries.length)],
                                "Sunset")
                ).toList();
    }
}