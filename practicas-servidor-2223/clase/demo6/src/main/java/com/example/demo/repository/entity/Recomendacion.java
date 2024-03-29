package com.example.demo.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="recomendaciones")
public class Recomendacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="observaciones")
	private String observaciones;
	
	@OneToOne(
			fetch = FetchType.LAZY, // Explicado en la otra
			optional = false)		// Obliga a que exista la relacion
	@JoinColumn(
			name = "idcliente") // Columna de la tabla recomendaciones donde se va a hacer el join
	@ToString.Exclude
	private Cliente cliente;
}
