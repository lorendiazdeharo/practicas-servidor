package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Cuenta;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Recomendacion;

import lombok.Data;
import lombok.ToString;

@Data
public class ClienteDTO implements Serializable {

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
	/*
	@ToString.Exclude
	private List<DireccionDTO> listaDireccionesDTO;
	*/
	@ToString.Exclude	
	private List<ClienteDireccionDTO> listaClientesDireccionesDTO;

	// Convertir de entidad a DTO. Este va a web
	public static ClienteDTO convertToDTO(Cliente cliente) {

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNif(cliente.getNif());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
		clienteDTO.setEmail(cliente.getEmail());

		RecomendacionDTO recomendacionDTO = 
				RecomendacionDTO.convertToDTO(cliente.getRecomendacion(), clienteDTO);
		clienteDTO.setRecomendacionDTO(recomendacionDTO);

		//Cargamos la lista de cuentas
		for(int i=0; i<cliente.getListaCuentas().size(); i++) {
			CuentaDTO cuentaDTO = CuentaDTO.convertToDTO(cliente.getListaCuentas().get(i), clienteDTO);
			clienteDTO.getListaCuentasDTO().add(cuentaDTO);
		}
		
		// Cargamos la lista de direcciones
		List<ClienteDireccion> listaClientesDirecciones = new ArrayList<ClienteDireccion>(cliente.getListaClientesDirecciones());
		for(int i=0; i<listaClientesDirecciones.size(); i++) {
			ClienteDireccionDTO cdDTO = new ClienteDireccionDTO();
			ClienteDireccion cd = listaClientesDirecciones.get(i);
			cdDTO.setId(cd.getId());
			cdDTO.setClienteDTO(clienteDTO);
			cdDTO.setDireccionDTO(DireccionDTO.convertToDTO(cd.getDireccion(),clienteDTO));
			cdDTO.setFechaAlta(cd.getFechaAlta());

			clienteDTO.getListaClientesDireccionesDTO().add(cdDTO);
		}		
		
		return clienteDTO;
	}

	// Convertir de DTO a entidad. Este va a BD
	public static Cliente convertToEntity(ClienteDTO clienteDTO) {

		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNif(clienteDTO.getNif());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setClaveSeguridad(clienteDTO.getClaveSeguridad());
		cliente.setEmail(clienteDTO.getEmail());
		
		Recomendacion recomendacion = 
				RecomendacionDTO.convertToEntity(clienteDTO.getRecomendacionDTO(), cliente);
		cliente.setRecomendacion(recomendacion);
		
		//Cargamos la lista de cuentas
		for(int i = 0; i<clienteDTO.listaCuentasDTO.size(); i++) {
			Cuenta cuenta = CuentaDTO.convertToEntity(clienteDTO.getListaCuentasDTO().get(i));
			cliente.getListaCuentas().add(cuenta);
		}

		// Cargamos la lista de direcciones
		for(int i=0; i<clienteDTO.getListaClientesDireccionesDTO().size(); i++) {
			ClienteDireccion cd = new ClienteDireccion();
			ClienteDireccionDTO cdDTO = clienteDTO.getListaClientesDireccionesDTO().get(i);
			cd.setId(cdDTO.getId());
			cd.setCliente(cliente);
			cd.setDireccion(DireccionDTO.convertToEntity(cdDTO.getDireccionDTO(), cliente));
			cd.setFechaAlta(cd.getFechaAlta());
			cliente.getListaClientesDirecciones().add(cd);
		}
				
		return cliente;
	}

	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
		this.listaCuentasDTO = new ArrayList<CuentaDTO>();
		this.listaClientesDireccionesDTO = new ArrayList<ClienteDireccionDTO>();
	}
}
