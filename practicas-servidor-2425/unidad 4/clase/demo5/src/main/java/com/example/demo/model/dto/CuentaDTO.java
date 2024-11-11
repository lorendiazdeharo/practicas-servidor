package com.example.demo.model.dto;

import java.util.Objects;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Cuenta;

import lombok.Data;

@Data
public class CuentaDTO {

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
	
	public CuentaDTO() {
		super();
		this.clienteDTO = new ClienteDTO();
	}

	public static CuentaDTO convertToDTO(Cuenta cuenta, ClienteDTO clienteDTO) {
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setId(cuenta.getId());
		cuentaDTO.setBanco(cuenta.getBanco());
		cuentaDTO.setSucursal(cuenta.getSucursal());
		cuentaDTO.setDc(cuenta.getDc());
		cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
		cuentaDTO.setSaldoActual(cuenta.getSaldoActual());
		
		cuentaDTO.setClienteDTO(clienteDTO);
		
		return cuentaDTO;
	}

	public static Cuenta convertToEntity(CuentaDTO cuentaDTO) {
		Cuenta cuenta = new Cuenta();
		cuenta.setId(cuentaDTO.getId());
		// Dejo sin hacer los demas
		
		Cliente cliente = ClienteDTO.convertToEntity(cuentaDTO.getClienteDTO());
		cuenta.setCliente(cliente);
		return cuenta;
		
	}
}
