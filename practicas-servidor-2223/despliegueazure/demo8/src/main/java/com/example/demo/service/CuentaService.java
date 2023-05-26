package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.CuentaDTO;

public interface CuentaService {

	public List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO);
	public void delete(CuentaDTO cuentaDTO);
	public void delete(CuentaDTO cuentaDTO, ClienteDTO clienteDTO);	
	public void save(CuentaDTO cuentaDTO);
}
