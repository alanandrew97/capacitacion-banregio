package com.example.capacitacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capacitacion.models.CaCatego;
import com.example.capacitacion.repositories.CaCategosRepository;

@Service
public class CaCategosService {
	@Autowired
	private CaCategosRepository caCategosRepository;
	
	public CaCatego create (CaCatego caCatego) {
		return caCategosRepository.save(caCatego);
	}
	
	public List<CaCatego> getAllCategos () {
		return caCategosRepository.findAll();
	}
	
	public Optional<CaCatego> get (int idCatego) {
		return caCategosRepository.findById(idCatego);
	}
	
	public void delete(int idCuenta) {
		caCategosRepository.deleteById(idCuenta);
	}
	
	public CaCatego update (CaCatego caCatego) {
		return caCategosRepository.save(caCatego);
	}
}
