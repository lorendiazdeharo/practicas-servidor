package com.example.demo.repository.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cuentaOrigen")
	@ToString.Exclude	
	private Set<Movimiento> movimientosOrigen;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cuentaDestino")
	@ToString.Exclude	
	private Set<Movimiento> movimientosDestino;	
	
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
	
	public Cuenta() {
		super();
		this.movimientosOrigen = new HashSet<Movimiento>();
		this.movimientosDestino = new HashSet<Movimiento>();
	}
}
