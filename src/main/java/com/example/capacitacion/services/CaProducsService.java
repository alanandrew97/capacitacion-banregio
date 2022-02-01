package com.example.capacitacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capacitacion.models.CaCatego;
import com.example.capacitacion.models.CaProduc;
import com.example.capacitacion.repositories.CaCategosRepository;
import com.example.capacitacion.repositories.CaProducsRepository;

@Service
public class CaProducsService {
	@Autowired
	private CaProducsRepository caProducsRepository;
	
	public CaProduc create (CaProduc caProduc) {
		return caProducsRepository.save(caProduc);
	}
	
	public List<CaProduc> getAllProducs () {
		return caProducsRepository.findAll();
	}
	
	public Optional<CaProduc> get (int idProduc) {
		return caProducsRepository.findById(idProduc);
	}
	
	public void delete(int idProduc) {
		caProducsRepository.deleteById(idProduc);
	}
	
	public CaProduc update (CaProduc caProduc) {
		return caProducsRepository.save(caProduc);
	}
}
