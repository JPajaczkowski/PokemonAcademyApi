package pl.sdaacademy.PokemonAcademyApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.PokemonAcademyApi.pokemondetails.NoPokemonFoundException;
import pl.sdaacademy.PokemonAcademyApi.pokemondetails.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemondetails.PokemonDetailsService;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.PokemonListEnvelop;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.PokemonListItem;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.PokemonListService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pokemon")
class PokemonController {

    private final PokemonListService pokemonListService;
    private final PokemonDetailsService pokemonDetailsService;

    @Autowired
    PokemonController(PokemonListService pokemonListService,
                      PokemonDetailsService pokemonDetailsService) {
        this.pokemonListService = pokemonListService;
        this.pokemonDetailsService = pokemonDetailsService;
    }

    @GetMapping("/list")
    PokemonListEnvelop getPokemonItemList(@RequestParam(defaultValue = "0") int offset,
                                          @RequestParam(defaultValue = "20") int limit) {
        return pokemonListService.getPokemonListItems(offset, limit);
    }

    @GetMapping
    List<PokemonDetails> getPokemonDetails(@RequestParam String names) {
        return pokemonDetailsService.getListOfPokemonDetails(names);
    }

    @ExceptionHandler(value = NoPokemonFoundException.class)
    public ResponseEntity<ErrorMessage> handleNoPokemonFoundException(NoPokemonFoundException exception) {
        return new ResponseEntity<>(new ErrorMessage(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}