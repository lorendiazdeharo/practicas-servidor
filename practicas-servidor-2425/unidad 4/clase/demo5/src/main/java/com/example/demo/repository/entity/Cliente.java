package com.example.demo.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Cliente {
	
	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	private Recomendacion recomendacion;
	
	private List<Cuenta> listaCuentas;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Cliente() {
		super();
		this.recomendacion = new Recomendacion();
		this.listaCuentas = new ArrayList<Cuenta>();
	}

}
