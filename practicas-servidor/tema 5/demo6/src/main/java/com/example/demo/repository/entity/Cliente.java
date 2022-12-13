package com.example.demo.repository.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nif")
	private String nif;

	@Column(name = "nombre")
	private String nombre;

	private String apellidos;

	@Column(name = "claveseguridad")
	private String claveSeguridad;

	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
	@ToString.Exclude
	private Recomendacion recomendacion;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Cuenta> listaCuentas;

	/*
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// Tabla que mantiene la relacion N-N
	@JoinTable(
			// Nombre de la tabla
			name = "clientesdirecciones",
			// columna que almacena el id de cliente en la tabla clientesdirecciones
			joinColumns = @JoinColumn(name = "idcliente"),
			// columna que almacena el id de la direccion en la tabla clientesdirecciones
			inverseJoinColumns = @JoinColumn(name = "iddireccion"))
	@ToString.Exclude
	private List<Direccion> listaDirecciones;
	*/

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// Tabla que mantiene la relacion N-N
	@JoinTable(
			// Nombre de la tabla
			name = "clientesdirecciones",
			// columna que almacena el id de cliente en la tabla clientesdirecciones
			joinColumns = @JoinColumn(name = "idcliente"),
			// columna que almacena el id de la direccion en la tabla clientesdirecciones
			inverseJoinColumns = @JoinColumn(name = "iddireccion"))
	@ToString.Exclude
	private Set<Direccion> listaDirecciones;
	
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
		//this.listaDirecciones = new ArrayList<Direccion>();
		this.listaDirecciones = new HashSet<Direccion>();
	}
}
