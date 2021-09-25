package pl.sdaacademy.PokemonAcademyApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sample")

public class RestTemplateExample {

    @GetMapping
    public String getPerson() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://swapi.dev/api/planets/1/?format=json";
        String response = restTemplate.getForEntity(url, String.class).getBody();
        return response;
    }

    @GetMapping("/v1")
    public Planet getPlanet() {
        RestTemplate restTemplate= new RestTemplate();
        String url = "https://swapi.dev/api/planets/1/?format=json";
        Planet planet = restTemplate.getForObject(url, Planet.class);
        return planet;
    }
}

class Planet {
    private String name;
    @JsonProperty("population")
    private String population1;
    @JsonProperty("surface_water")
    private String surfaceWater;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getPopulation1() {
        return population1;
    }

    public void setPopulation1(String population) {
        this.population1 = population;
    }
}
