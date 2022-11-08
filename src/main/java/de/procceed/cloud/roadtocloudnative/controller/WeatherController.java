package de.procceed.cloud.roadtocloudnative.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class WeatherController {

    @Autowired
    private Environment env;

    @Value("${TARGET:World}")
    String target;

    Map<String, Double> weatherData = Map.of(
            "Nürnberg", 24.0,
            "Fürth", 10.0
    );

    @GetMapping("v1/weather")
    public String getWeather(@RequestParam(name = "location") Optional<String> optLocation) {
        String defaultLocation = "Nürnberg";

        String location = optLocation.orElse(defaultLocation);

        if (weatherData.containsKey(location)) {
            return "HOSTNAME: " + env.getProperty("hostname") + " - Message: " + weatherData.get(location).toString();
        } else {
            return "HOSTNAME: " + env.getProperty("hostname") + " - Message: No weather data available for location: " + location;
        }
    }

    @GetMapping("/")
    String hello() {
        return "Hello " + target + "!";
    }

}
