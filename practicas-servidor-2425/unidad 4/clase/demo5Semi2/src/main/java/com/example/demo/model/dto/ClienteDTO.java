package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.repository.entity.Cliente;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	private RecomendacionDTO recomendacionDTO;
	private List<CuentaDTO> listaCuentasDTO;

	//Convierte una entidad a un objeto DTO
	public static ClienteDTO convertToDTO(Cliente cliente) {
		// Creamos el clienteDTO y asignamos los valores basicos
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNif(cliente.getNif());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
		clienteDTO.setEmail(cliente.getEmail());
		// Asignamos la recomendacionDTO pasandole el clienteDTO como parametrio
		clienteDTO.setRecomendacionDTO(RecomendacionDTO.convertToDTO(cliente.getRecomendacion(), clienteDTO));
		
		// Retorna el DTO
		return clienteDTO;
	}
	
	// Convierte un objeto DTO a una entidad
	public static Cliente convertToEntity(ClienteDTO clienteDTO) {
		// Creamos la entidad cliente y le asignamos los valores
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNif(clienteDTO.getNif());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setClaveSeguridad(clienteDTO.getClaveSeguridad());
		cliente.setEmail(clienteDTO.getEmail());
		// Asignamos la recomendacion pasandole el cliente como parametro
		cliente.setRecomendacion(RecomendacionDTO.convertToEntity(clienteDTO.getRecomendacionDTO(), cliente));
		
		// Retorna la entidad
		return cliente;
	}
	
	// Constructor vacio
	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
		this.listaCuentasDTO = new ArrayList<CuentaDTO>();
	}	
}
