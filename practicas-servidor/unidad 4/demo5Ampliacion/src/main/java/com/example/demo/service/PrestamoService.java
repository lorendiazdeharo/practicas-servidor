package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PrestamoDTO;

public interface PrestamoService {

	List<PrestamoDTO> findAllByCliente(ClienteDTO clienteDTO);

}
