package com.example.capacitacion.models;

import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class HeldItem {
	private HashMap<String, Object> item;
	private List<HashMap<String, Object>> version_details;
}
