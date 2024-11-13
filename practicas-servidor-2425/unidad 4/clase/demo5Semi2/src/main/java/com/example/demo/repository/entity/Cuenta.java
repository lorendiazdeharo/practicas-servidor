package com.example.demo.repository.entity;

import java.util.Objects;

import lombok.Data;

@Data
public class Cuenta {

	private Long id;
	private String banco;
	private String sucursal;
	private String dc;
	private String numeroCuenta;
	private Double saldoActual;
	
	private Cliente cliente;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
