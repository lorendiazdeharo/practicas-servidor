package com.example.demo.service;

import java.util.List;
import com.example.demo.model.dto.ClienteDTO;

public interface ClienteService {
	
	void save(ClienteDTO clienteDTO);
	ClienteDTO findById(ClienteDTO clienteDTO);
	List<ClienteDTO> findAll();
	ClienteDTO delete(ClienteDTO clienteDTO);
}
