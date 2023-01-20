package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.repository.entity.ClienteDireccion;

import lombok.Data;

@Data
public class ClienteDireccionDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private ClienteDTO clienteDTO;	
	private DireccionDTO direccionDTO;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date fechaAlta;

	public static ClienteDireccionDTO convertToDTO(ClienteDireccion cd) {
		ClienteDireccionDTO cdDTO = new ClienteDireccionDTO();
		cdDTO.setId(cd.getId());
		
		ClienteDTO clienteDTO = ClienteDTO.convertToDTO(cd.getCliente());
		cdDTO.setClienteDTO(clienteDTO);
		cdDTO.setDireccionDTO(DireccionDTO.convertToDTO(cd.getDireccion(), clienteDTO));
		cdDTO.setFechaAlta(cd.getFechaAlta());
		return cdDTO;
	}


}
