package com.example.capacitacion.models;

import java.util.HashMap;

import lombok.Data;

@Data
public class PokemonAbility {
	private boolean isHidden;
	private int slot;
	private HashMap<String, Object> ability;
}
