package com.example.capacitacion.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name="caproduc")
@Data
public class CaProduc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proNumero;
	
	private int proNumcat;
	private String proNombre;
}
