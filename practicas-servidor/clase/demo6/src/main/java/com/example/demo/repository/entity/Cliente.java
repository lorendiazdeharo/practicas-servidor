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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nif")
	private String nif;
	
	@Column(name="nombre")	
	private String nombre;
	
	private String apellidos;
	
	@Column(name="claveseguridad")
	private String claveSeguridad;
	
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, // Modo de recuperacion de los datos relacionados con cliente
			cascade = CascadeType.ALL, // Modo en que se aplican las operaciones a las tablas relacionadas con cliente
			 mappedBy = "cliente")  // Nombre del atributo en la otra clase donde está representada la clase Cliente
	@ToString.Exclude
	private Recomendacion recomendacion;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "cliente")
	@ToString.Exclude	
	private List<Cuenta> listaCuentas;
	
	/*
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "clientesdirecciones", // Nombre de la tabla intermedia
				joinColumns = @JoinColumn(name = "idcliente"),  // Clave foranea de la clase en la que defino esto, que es Cliente
				inverseJoinColumns = @JoinColumn(name = "iddireccion")) // Clave foranea de la clase con la que se relaciona, que es Direccion
	@ToString.Exclude
	private Set<Direccion> listaDirecciones;
	*/
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "cliente")
	@ToString.Exclude	
	private Set<ClienteDireccion> listaClientesDirecciones;	
	
	
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
		this.listaCuentas = new ArrayList<Cuenta>();
		this.listaClientesDirecciones = new HashSet<ClienteDireccion>(); 
	}	
	
	
	
	
}
