package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.ClienteDireccionDTO;
import com.example.demo.model.dto.DireccionDTO;

public interface DireccionService {

	public List<ClienteDireccionDTO> findAllByCliente(ClienteDTO clienteDTO);
	public void save(DireccionDTO direccionDTO) ;

}
