package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;

public interface ClienteService {

	List<ClienteDTO> findAll();
	void save(ClienteDTO clienteDTO);
	ClienteDTO findById(ClienteDTO clienteDTO);
	void delete(ClienteDTO clienteDTO);
}
