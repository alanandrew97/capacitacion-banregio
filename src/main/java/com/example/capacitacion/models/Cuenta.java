package com.example.capacitacion.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name="Cuenta")
@Data
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcuenta;
	
	private int numero;
	private int clienteid;
	private String nombre;
	private Calendar createdat;
}
