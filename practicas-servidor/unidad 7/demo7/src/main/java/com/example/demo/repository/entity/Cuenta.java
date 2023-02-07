package com.example.demo.repository.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cuentas")
public class Cuenta implements Comparable {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String banco;
	private String sucursal;
	private String dc;
	
	@Column(name = "numerocuenta")
	private String numeroCuenta;

	@Column(name = "saldoactual")
	private float saldoActual;
	
	@ManyToOne
	@JoinColumn(name = "idcliente")
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

	@Override
	public int compareTo(Object o) {
		Cuenta c = (Cuenta)o;
		if(this.id == c.id) 
			return 0;
		else
			return 1; 
	}
}
