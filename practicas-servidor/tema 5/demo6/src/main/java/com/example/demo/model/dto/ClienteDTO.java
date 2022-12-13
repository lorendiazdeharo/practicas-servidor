package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Cuenta;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Recomendacion;

import lombok.Data;
import lombok.ToString;

@Data
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	@ToString.Exclude		
	private RecomendacionDTO recomendacionDTO;	
	@ToString.Exclude	
	private List<CuentaDTO> listaCuentasDTO;
	@ToString.Exclude
	private List<DireccionDTO> listaDireccionesDTO;	
	
	// Convertir una entidad a un DTO
	public static ClienteDTO convertToDTO(Cliente cliente) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNif(cliente.getNif());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
		clienteDTO.setEmail(cliente.getEmail());
		
		RecomendacionDTO rec = RecomendacionDTO.converToDTO(cliente.getRecomendacion(), clienteDTO);
		clienteDTO.setRecomendacionDTO(rec);
		// Cargamos la lista de cuentas
		for(int i=0;i<cliente.getListaCuentas().size();i++) {
			CuentaDTO cuentadto = CuentaDTO.convertToDTO(cliente.getListaCuentas().get(i), clienteDTO);
			clienteDTO.getListaCuentasDTO().add(cuentadto);			
		}		
		// Cargamos la lista de direcciones
		List<Direccion> listaDirecciones = new ArrayList<Direccion>(cliente.getListaDirecciones());
		for(int i=0;i<listaDirecciones.size();i++) {
			DireccionDTO direccionDTO = DireccionDTO.convertToDTO(listaDirecciones.get(i), clienteDTO);
			clienteDTO.getListaDireccionesDTO().add(direccionDTO);				
		}
		/*
		for(int i=0;i<cliente.getListaDirecciones().size();i++) {
			DireccionDTO direccionDTO = DireccionDTO.convertToDTO(cliente.getListaDirecciones().get(i), clienteDTO);
			clienteDTO.getListaDireccionesDTO().add(direccionDTO);			
		}
		*/		
		
		return clienteDTO;
	}
	
	// Convertir un DTO a una entidad
	public static Cliente convertToEntity(ClienteDTO clienteDTO) {
	
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNif(clienteDTO.getNif());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setClaveSeguridad(clienteDTO.getClaveSeguridad());
		cliente.setEmail(clienteDTO.getEmail());
		
		Recomendacion rec = RecomendacionDTO.convertToEntity(clienteDTO.getRecomendacionDTO(), cliente);
		cliente.setRecomendacion(rec);
		
		// Cargamos la lista de cuentas
		for(int i=0;i<clienteDTO.getListaCuentasDTO().size();i++) {
			Cuenta cuenta = CuentaDTO.convertToEntity(clienteDTO.getListaCuentasDTO().get(i));
			cliente.getListaCuentas().add(cuenta);			
		}			
		// Cargamos la lista de direcciones
		for(int i=0;i<clienteDTO.getListaDireccionesDTO().size();i++) {
			Direccion direccion = DireccionDTO.convertToEntity(clienteDTO.getListaDireccionesDTO().get(i), cliente);
			cliente.getListaDirecciones().add(direccion);			
		}		
		
		return cliente;		
	}

	// Constructor vacio
	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
		this.listaCuentasDTO = new ArrayList<CuentaDTO>();
		this.listaDireccionesDTO = new ArrayList<DireccionDTO>();		
	}
}
