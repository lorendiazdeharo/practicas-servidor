package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Objects;

import com.example.demo.repository.entity.Cuenta;

import lombok.Data;

@Data
public class CuentaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String banco;
	private String sucursal;
	private String dc;
	private String numeroCuenta;
	private Double saldoActual;
	
	private ClienteDTO clienteDTO;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaDTO other = (CuentaDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public static CuentaDTO convertToDTO(Cuenta c, ClienteDTO clienteDTO) {
		CuentaDTO cDTO = new CuentaDTO();
		cDTO.setId(c.getId());
		cDTO.setBanco(c.getBanco());
		cDTO.setSucursal(c.getSucursal());
		cDTO.setDc(c.getDc());
		cDTO.setNumeroCuenta(c.getNumeroCuenta());
		cDTO.setSaldoActual(c.getSaldoActual());
		
		cDTO.setClienteDTO(clienteDTO);		
		return cDTO;
	}	
	
	
}
