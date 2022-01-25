package com.example.capacitacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capacitacion.models.Cuenta;
import com.example.capacitacion.repositories.CuentaRepository;

@Service
public class CuentaService {
	@Autowired
	private CuentaRepository cuentaRepository;
	
	public Cuenta create (Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}
	
	public List<Cuenta> getAllCuentas () {
		return cuentaRepository.findAll();
	}
	
	public Optional<Cuenta> getCuenta (int idCuenta) {
		return cuentaRepository.findById(idCuenta);
	}
	
	public void deleteCuenta(int idCuenta) {
		cuentaRepository.deleteById(idCuenta);
	}
	
	public Cuenta updateCuenta (Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}
}
