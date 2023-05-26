package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Cuenta;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Recomendacion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	@JsonManagedReference
	private RecomendacionDTO recomendacionDTO;	
	@ToString.Exclude
	@JsonManagedReference
	private List<CuentaDTO> listaCuentasDTO;
	
	//@ToString.Exclude
	//private List<DireccionDTO> listaDireccionesDTO;
	
	@ToString.Exclude
	@JsonIgnore	
	private List<ClienteDireccionDTO> listaClientesDireccionesDTO;
	
	@DateTimeFormat(iso=ISO.DATE)
	private Date fechaNacimiento;
	
	// Convertir una entidad a un DTO
	public static ClienteDTO convertToDTO(Cliente cliente) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNif(cliente.getNif());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
		
		RecomendacionDTO rec = RecomendacionDTO.converToDTO(cliente.getRecomendacion(), clienteDTO);
		clienteDTO.setRecomendacionDTO(rec);
		
		// Cargamos la lista de cuentas, que como es un HashSet hemos de convertirla a ArrayList
		List<Cuenta> listaCuentas = new ArrayList<Cuenta>(cliente.getListaCuentas());		
		for(int i=0;i<listaCuentas.size();i++) {
			CuentaDTO cuentadto = CuentaDTO.convertToDTO(listaCuentas.get(i), clienteDTO);
			clienteDTO.getListaCuentasDTO().add(cuentadto);			
		}
		
		/*
		for(int i=0;i<cliente.getListaDirecciones().size();i++) {
			DireccionDTO direccionDTO = DireccionDTO.convertToDTO(cliente.getListaDirecciones().get(i), clienteDTO);
			clienteDTO.getListaDireccionesDTO().add(direccionDTO);			
		}
		*/	
		
		// Cargamos la lista de clientes direcciones, que como es un HashSet hemos de convertirla a ArrayList
		List<ClienteDireccion> listaClientesDirecciones = new ArrayList<ClienteDireccion>(cliente.getListaClientesDirecciones());
		for(int i=0;i<listaClientesDirecciones.size();i++) {
			ClienteDireccionDTO clienteDireccionDTO = new ClienteDireccionDTO();
			clienteDireccionDTO.setClienteDTO(clienteDTO);
			clienteDireccionDTO.setDireccionDTO(DireccionDTO.convertToDTO(listaClientesDirecciones.get(i).getDireccion(), clienteDTO));
			clienteDireccionDTO.setFechaAlta(listaClientesDirecciones.get(i).getFechaAlta());
			clienteDTO.getListaClientesDireccionesDTO().add(clienteDireccionDTO);				
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
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		
		Recomendacion rec = RecomendacionDTO.convertToEntity(clienteDTO.getRecomendacionDTO(), cliente);
		cliente.setRecomendacion(rec);
		
		// Cargamos la lista de cuentas
		for(int i=0;i<clienteDTO.getListaCuentasDTO().size();i++) {
			Cuenta cuenta = CuentaDTO.convertToEntity(clienteDTO.getListaCuentasDTO().get(i));
			cliente.getListaCuentas().add(cuenta);			
		}			
		// Cargamos la lista de direccionesDTO
		for(int i=0;i<clienteDTO.getListaClientesDireccionesDTO().size();i++) {
			ClienteDireccion cd = new ClienteDireccion();
			cd.setId(clienteDTO.getListaClientesDireccionesDTO().get(i).getId());
			cd.setCliente(cliente);
			cd.setDireccion(DireccionDTO.convertToEntity(clienteDTO.getListaClientesDireccionesDTO().get(i).getDireccionDTO(), cliente));
			cd.setFechaAlta(clienteDTO.getListaClientesDireccionesDTO().get(i).getFechaAlta());
			cliente.getListaClientesDirecciones().add(cd);			
		}		
		
		return cliente;		
	}

	// Constructor vacio
	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
		this.listaCuentasDTO = new ArrayList<CuentaDTO>();
		this.listaClientesDireccionesDTO = new ArrayList<ClienteDireccionDTO>();		
	}
}
