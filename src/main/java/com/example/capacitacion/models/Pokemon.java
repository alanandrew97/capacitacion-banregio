package com.example.capacitacion.models;

import java.util.List;

import lombok.Data;

@Data
public class Pokemon {
	private int id;
	private String name;
	private int base_experience;
	private String location_area_encounters;
	private List<PokemonAbility> abilities;
	private List<HeldItem> held_items;
}
