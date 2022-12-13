package com.example.demo.repository.entity;

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
	
	private String observaciones;
	
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcliente")
	@ToString.Exclude
	private Cliente cliente;
}
