package com.example.capacitacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.capacitacion.models.Pokemon;

@Service
public class PokemonService {
	@Autowired
	RestTemplate restTemplate;
	
	public Pokemon getPokemon(String nombre) {
        ResponseEntity<Pokemon> response =
                restTemplate.getForEntity(
                "https://pokeapi.co/api/v2/pokemon/" + nombre,
                Pokemon.class);
              Pokemon pokemon = response.getBody();
      return pokemon;
	}
}
