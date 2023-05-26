package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;

public interface ClienteService {

	List<ClienteDTO> findAll();
	ClienteDTO findById(ClienteDTO clienteDTO);
	ClienteDTO save(ClienteDTO clienteDTO);
	void delete(ClienteDTO clienteDTO);
	List<ClienteDTO> findByApellidos(String apellidos);	
}
