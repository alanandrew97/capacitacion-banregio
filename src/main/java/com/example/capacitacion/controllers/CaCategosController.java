package com.example.capacitacion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capacitacion.entity.CaCatego;
import com.example.capacitacion.services.CaCategosService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
public class CaCategosController {
	@Autowired
	private CaCategosService categoService;
	
	@GetMapping
	private ResponseEntity<List<CaCatego>> getCaCategos() {
		try {
			return ResponseEntity.ok(categoService.getAllCategos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<CaCatego> getCaCatego(@PathVariable int id) {
		try {
			Optional<CaCatego> catego = categoService.get(id);
			return catego.isPresent() ? ResponseEntity.ok(catego.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping
	private ResponseEntity<CaCatego> createCaCatego(@RequestBody CaCatego catego) {
		try {
			CaCatego newCaCatego = categoService.create(catego);
			
			return ResponseEntity.ok(newCaCatego);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<CaCatego> updateCaCatego(@PathVariable int id, @RequestBody CaCatego catego) {
		try {
			catego.setCatNumero(id);
			CaCatego newCaCatego = categoService.update(catego);
			
			return ResponseEntity.ok(newCaCatego);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
	private ResponseEntity<CaCatego> patchCaCatego(@PathVariable int id, @RequestBody CaCatego catego) {
		try {
			CaCatego oldCaCatego = categoService.get(id).get();
			catego.setCatNumero(id);
			
			CaCatego newCaCatego = new CaCatego();
			
			newCaCatego.setCatNumero(id);
			newCaCatego.setCatNombre(catego.getCatNombre().equals("") ? catego.getCatNombre() : oldCaCatego.getCatNombre());

			newCaCatego = categoService.update(newCaCatego);

			return ResponseEntity.ok(newCaCatego);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<CaCatego> deleteCaCatego(@PathVariable int id) {
		try {
			categoService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
