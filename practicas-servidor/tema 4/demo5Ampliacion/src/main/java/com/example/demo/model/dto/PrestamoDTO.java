package com.example.demo.model.dto;

import java.io.Serializable;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Prestamo;

import lombok.Data;
import lombok.ToString;

@Data
public class PrestamoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String numero;
	private Float importe;
	private Float tipoInteres;
	@ToString.Exclude	
	private ClienteDTO clienteDTO;
	
	public static  PrestamoDTO convertToDTO(Prestamo prestamo, ClienteDTO clienteDTO) {
		PrestamoDTO prestamoDTO = new PrestamoDTO();
		prestamoDTO.setId(prestamo.getId());
		prestamoDTO.setImporte(prestamo.getImporte());
		prestamoDTO.setNumero(prestamo.getNumero());
		prestamoDTO.setTipoInteres(prestamo.getTipoInteres());
		prestamoDTO.setClienteDTO(clienteDTO);
		
		return prestamoDTO;
	}
	
	public static Prestamo convertToEntity(PrestamoDTO prestamoDTO, Cliente cliente) {
		
		Prestamo prestamo = new Prestamo();
		prestamo.setId(prestamoDTO.getId());
		prestamo.setImporte(prestamoDTO.getImporte());
		prestamo.setNumero(prestamoDTO.getNumero());
		prestamo.setTipoInteres(prestamoDTO.getTipoInteres());
		prestamo.setCliente(cliente);
		
		return prestamo;
	}
	
	
}
