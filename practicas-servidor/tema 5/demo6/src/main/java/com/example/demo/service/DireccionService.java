package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.DireccionDTO;

public interface DireccionService {

	public List<DireccionDTO> findAllByCliente(ClienteDTO clienteDTO);
	public void save(DireccionDTO direccionDTO);

}
