package com.example.demo.repository.entity;

import java.util.Objects;

import lombok.Data;
import lombok.ToString;

@Data
public class Recomendacion {
	
	private Long id;
	private String observaciones;
	@ToString.Exclude
	private Cliente cliente;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recomendacion other = (Recomendacion) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
