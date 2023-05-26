package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Direccion;

import lombok.Data;
import lombok.ToString;

@Data
public class DireccionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private String pais;
	private String cp;
	@ToString.Exclude
	private List<ClienteDTO> listaClientesDTO;

	public static DireccionDTO convertToDTO(Direccion direccion, ClienteDTO clienteDTO) {
		DireccionDTO direccionDTO = new DireccionDTO();
		direccionDTO.setId(direccion.getId());
		direccionDTO.setDescripcion(direccion.getDescripcion());
		direccionDTO.setPais(direccion.getPais());
		direccionDTO.setCp(direccion.getCp());

		// No tiene sentido mapear todos los clientes que tiene la direccion, puesto que
		// al mapear cada cliente volveriamos a mapear sus direcciones, y así
		// sucesivamente.
		direccionDTO.getListaClientesDTO().add(clienteDTO);

		return direccionDTO;
	}

	public static Direccion convertToEntity(DireccionDTO direccionDTO, Cliente cliente) {
		Direccion direccion = new Direccion();
		direccion.setId(direccionDTO.getId());
		direccion.setDescripcion(direccionDTO.getDescripcion());
		direccion.setPais(direccionDTO.getPais());
		direccion.setCp(direccionDTO.getCp());

		// No tiene sentido mapear todos los clientes que tiene la direccion, puesto que
		// al mapear cada cliente volveriamos a mapear sus direcciones, y así
		// sucesivamente.
		//direccion.getListaClientes().add(cliente);			

		return direccion;

	}

	// Constructor vacio
	public DireccionDTO() {
		super();
		this.listaClientesDTO = new ArrayList<ClienteDTO>();
	}
}
