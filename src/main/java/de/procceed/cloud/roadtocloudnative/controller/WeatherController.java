package de.procceed.cloud.roadtocloudnative.controller;

import de.procceed.cloud.roadtocloudnative.model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class WeatherController {
    private final String defaultLocation = "Nürberg";

    @Autowired
    private Environment env;

    @Value("${TARGET:World}")
    String target;

    Map<String, WeatherData> weatherDataMap = Map.of(
            "Nürnberg", new WeatherData(25.0, "cloudless"),
            "Fürth", new WeatherData(-5.3, "rainy")
    );

    @GetMapping("v1/weather")
    public String getWeather(Model model, @RequestParam(name = "location") Optional<String> optLocation) {

        String location = optLocation.orElse(defaultLocation);

        if (weatherDataMap.containsKey(location)) {
            model.addAttribute("weatherDataAvailable", true);
            model.addAttribute("weatherData", weatherDataMap.get(location));
        } else {
            model.addAttribute("weatherDataAvailable", false);
        }

        model.addAttribute("location", location);
        model.addAttribute("hostname", env.getProperty("hostname"));

        return "main";
    }

    @GetMapping("/")
    String hello() {
        return "Hello " + target + "!";
    }

}
