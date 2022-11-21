package com.example.demo.repository.entity;

import lombok.Data;

@Data
public class Prestamo {

	private Long id;
	private String numero;
	private Float importe;
	private Float tipoInteres;
	private Cliente cliente;
}
