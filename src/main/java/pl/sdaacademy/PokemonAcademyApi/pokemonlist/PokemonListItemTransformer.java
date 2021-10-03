package pl.sdaacademy.PokemonAcademyApi.pokemonlist;


import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.pokemondetails.PokemonDetails;

@Component
class PokemonListItemTransformer {

    PokemonListItem toEntity(PokemonDetails pokemonDetails) {
        PokemonListItem pokemonListItem = new PokemonListItem();
        pokemonListItem.setName(pokemonDetails.getName());
        pokemonListItem.setImageUrl(pokemonDetails.getImageUrl());
        return pokemonListItem;
    }
}