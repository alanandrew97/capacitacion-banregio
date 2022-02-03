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

import com.example.capacitacion.entity.CaProduc;
import com.example.capacitacion.services.CaProducsService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8090"}, maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class CaProducsController {
	@Autowired
	private CaProducsService producService;
	
	@GetMapping
	public ResponseEntity<List<CaProduc>> getCaProducs() {
		try {
			return ResponseEntity.ok(producService.getAllProducs());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CaProduc> getCaProduc(@PathVariable int id) {
		try {
			Optional<CaProduc> produc = producService.get(id);
			return produc.isPresent() ? ResponseEntity.ok(produc.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<CaProduc> createCaProduc(@RequestBody CaProduc produc) {
		try {
			CaProduc newCaProduc = producService.create(produc);
			
			return ResponseEntity.ok(newCaProduc);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CaProduc> updateCaProduc(@PathVariable int id, @RequestBody CaProduc produc) {
		try {
			produc.setProNumero(id);
			CaProduc newCaProduc = producService.update(produc);
			
			return ResponseEntity.ok(newCaProduc);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
	public ResponseEntity<CaProduc> patchCaProduc(@PathVariable int id, @RequestBody CaProduc produc) {
		try {
			CaProduc oldCaProduc = producService.get(id).get();
			produc.setProNumero(id);
			
			CaProduc newCaProduc = new CaProduc();
			
			newCaProduc.setProNumero(id);
			newCaProduc.setProNombre(produc.getProNombre().equals("") ? produc.getProNombre() : oldCaProduc.getProNombre());
			newCaProduc.setProNumcat(produc.getProNumcat() != 0 ? produc.getProNumcat() : oldCaProduc.getProNumcat());

			newCaProduc = producService.update(newCaProduc);

			return ResponseEntity.ok(newCaProduc);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CaProduc> deleteCaProduc(@PathVariable int id) {
		try {
			producService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
