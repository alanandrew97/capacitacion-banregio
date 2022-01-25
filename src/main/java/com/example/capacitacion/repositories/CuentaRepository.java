package com.example.capacitacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capacitacion.models.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

}
