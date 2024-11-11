package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.CuentaDTO;

public interface CuentaService {

	List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO);

	void delete(CuentaDTO cuentaDTO);

}
