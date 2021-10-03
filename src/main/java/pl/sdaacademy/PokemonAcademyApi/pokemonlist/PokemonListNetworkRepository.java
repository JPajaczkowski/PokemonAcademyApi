package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
class PokemonListNetworkRepository {

    private final static String ENDPOINT = "pokemon/?offset=%d&limit=%d";
    private final RestTemplate restTemplate;
    private final String endpointUrl;

    PokemonListNetworkRepository(@Value("${pokemonapi.url}") String baseUrl,
                                 RestTemplate restTemplate) {
        this.endpointUrl = baseUrl + ENDPOINT;
        this.restTemplate = restTemplate;
    }

    PokemonListResult fetchPokemonList(int offset, int limit) {
        String url = String.format(endpointUrl, offset, limit);
        return restTemplate.getForObject(url, PokemonListResult.class);
    }
}