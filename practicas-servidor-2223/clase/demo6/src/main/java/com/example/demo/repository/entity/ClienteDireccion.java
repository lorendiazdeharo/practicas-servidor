package com.example.demo.repository.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="clientesdirecciones")
public class ClienteDireccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idcliente")
	@ToString.Exclude
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="iddireccion")
	@ToString.Exclude	
	private Direccion direccion;
	
	@Column(name="fechaalta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDireccion other = (ClienteDireccion) obj;
		return Objects.equals(cliente.getId(), other.cliente.getId()) && 
				Objects.equals(direccion.getId(), other.direccion.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente.getId(), direccion.getId());
	}
	
	

}
