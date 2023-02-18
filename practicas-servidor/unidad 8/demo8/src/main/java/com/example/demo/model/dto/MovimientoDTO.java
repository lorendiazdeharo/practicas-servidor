package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.repository.entity.Cuenta;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Movimiento;

import lombok.Data;


@Data
public class MovimientoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipo;
	private Date fechaOperacion;
	private String descripcion;
	private Float importe;
	private CuentaDTO cuentaOrigenDTO;
	private CuentaDTO cuentaDestinoDTO;
	
	public static MovimientoDTO convertToDTO(Movimiento movimiento) {
		
		MovimientoDTO movimientoDTO = new MovimientoDTO();
		movimientoDTO.setId(movimiento.getId());
		movimientoDTO.setTipo(movimiento.getTipo());
		movimientoDTO.setFechaOperacion(movimiento.getFechaOperacion());
		movimientoDTO.setDescripcion(movimiento.getDescripcion());
		movimientoDTO.setImporte(movimiento.getImporte());
		movimientoDTO.setCuentaOrigenDTO(CuentaDTO.convertToDTO(movimiento.getCuentaOrigen()));
		movimientoDTO.setCuentaDestinoDTO(CuentaDTO.convertToDTO(movimiento.getCuentaDestino()));
		
		return movimientoDTO;
	}
	
}
