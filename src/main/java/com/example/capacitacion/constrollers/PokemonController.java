package com.example.capacitacion.constrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capacitacion.models.HeldItem;
import com.example.capacitacion.models.Pokemon;
import com.example.capacitacion.models.PokemonAbility;
import com.example.capacitacion.services.PokemonService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
	@Autowired
	PokemonService pokemonService;
	
	@GetMapping("/{nombre}/id")
	private ResponseEntity<Integer> getPokemonId(@PathVariable String nombre) {
		try {
			return ResponseEntity.ok(pokemonService.getPokemon(nombre).getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{nombre}/abilities")
	private ResponseEntity<List<PokemonAbility>> getPokemonAbilities(@PathVariable String nombre) {
		try {
			return ResponseEntity.ok(pokemonService.getPokemon(nombre).getAbilities());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{nombre}/base-experiences")
	private ResponseEntity<Integer> getPokemonBaseExperiences(@PathVariable String nombre) {
		try {
			return ResponseEntity.ok(pokemonService.getPokemon(nombre).getBase_experience());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{nombre}/held-items")
	private ResponseEntity<List<HeldItem>> getPokemonHeldItems(@PathVariable String nombre) {
		try {
			return ResponseEntity.ok(pokemonService.getPokemon(nombre).getHeld_items());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{nombre}/name")
	private ResponseEntity<String> getPokemonName(@PathVariable String nombre) {
		try {
			return ResponseEntity.ok(pokemonService.getPokemon(nombre).getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{nombre}/location-area-encounters")
	private ResponseEntity<String> getPokemonLocationAreaEncounters(@PathVariable String nombre) {
		try {
			return ResponseEntity.ok(pokemonService.getPokemon(nombre).getLocation_area_encounters());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
