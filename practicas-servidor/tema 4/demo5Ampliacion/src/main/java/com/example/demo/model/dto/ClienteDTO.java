package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Prestamo;
import com.example.demo.repository.entity.Recomendacion;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 2L;
	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	private RecomendacionDTO recomendacionDTO;	
	private List<PrestamoDTO> listaPrestamosDTO;
	
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
		
		for (Prestamo prestamo : cliente.getListaPrestamos()) {
			PrestamoDTO prestamoDTO = PrestamoDTO.convertToDTO(prestamo, clienteDTO);
			clienteDTO.getListaPrestamosDTO().add(prestamoDTO);
		}
		
		
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
		
		for (PrestamoDTO prestamoDTO : clienteDTO.getListaPrestamosDTO()) {
			Prestamo prestamo = PrestamoDTO.convertToEntity(prestamoDTO, cliente);
			cliente.getListaPrestamos().add(prestamo);
		}
		
		return cliente;
				
	}

	// Constructor vacio
	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
		this.listaPrestamosDTO = new ArrayList<PrestamoDTO>();
	}
	
	
}
