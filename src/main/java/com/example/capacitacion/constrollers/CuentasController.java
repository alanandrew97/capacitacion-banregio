package com.example.capacitacion.constrollers;

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

import com.example.capacitacion.models.Cuenta;
import com.example.capacitacion.services.CuentaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/cuentas")
public class CuentasController {
	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping
	private ResponseEntity<List<Cuenta>> getCuentas() {
		try {
			return ResponseEntity.ok(cuentaService.getAllCuentas());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Cuenta> getCuenta(@PathVariable int id) {
		try {
			Optional<Cuenta> cuenta = cuentaService.getCuenta(id);
			return cuenta.isPresent() ? ResponseEntity.ok(cuenta.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping
	private ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
		try {
			Cuenta newCuenta = cuentaService.create(cuenta);
			
			return ResponseEntity.ok(newCuenta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Cuenta> updateCuenta(@PathVariable int id, @RequestBody Cuenta cuenta) {
		try {
			cuenta.setIdcuenta(id);
			Cuenta newCuenta = cuentaService.updateCuenta(cuenta);
			
			return ResponseEntity.ok(newCuenta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
	private ResponseEntity<Cuenta> patchCuenta(@PathVariable int id, @RequestBody Cuenta cuenta) {
		try {
			Cuenta oldCuenta = cuentaService.getCuenta(id).get();
			cuenta.setIdcuenta(id);
			
			Cuenta newCuenta = new Cuenta();
			
			newCuenta.setIdcuenta(id);
			newCuenta.setClienteid(cuenta.getClienteid() != 0 ? cuenta.getClienteid() : oldCuenta.getClienteid());
			newCuenta.setNumero(cuenta.getNumero() != 0 ? cuenta.getNumero() : oldCuenta.getNumero());

			newCuenta = cuentaService.updateCuenta(newCuenta);

			return ResponseEntity.ok(newCuenta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Cuenta> deleteCuenta(@PathVariable int id) {
		try {
			cuentaService.deleteCuenta(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
