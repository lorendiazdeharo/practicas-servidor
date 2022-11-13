package com.example.demo.repository.entity;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.RecomendacionDTO;

import lombok.Data;
import lombok.ToString;

@Data
public class Recomendacion {
	
	private Long id;
	private String observaciones;
	@ToString.Exclude
	private Cliente cliente;
	

}
