package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;

public interface ClienteService {

	List<ClienteDTO> findAll();
	ClienteDTO findById(ClienteDTO clienteDTO);
	void save(ClienteDTO clienteDTO);
	void delete(ClienteDTO clienteDTO);
}
