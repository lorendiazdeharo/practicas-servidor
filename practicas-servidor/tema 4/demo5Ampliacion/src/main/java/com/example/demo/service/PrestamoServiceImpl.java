package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PrestamoDTO;
import com.example.demo.repository.dao.PrestamoRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Prestamo;

@Service
public class PrestamoServiceImpl implements PrestamoService{

	private static final Logger log = LoggerFactory.getLogger(PrestamoServiceImpl.class);
	
	@Autowired
	private PrestamoRepository prestamoRepository;

	@Override
	public List<PrestamoDTO> findAllByCliente(ClienteDTO clienteDTO) {
		
		Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
		List<Prestamo> listaPrestamos = prestamoRepository.findAllByCliente(cliente);
		
		List<PrestamoDTO> listaPrestamosDTO = new ArrayList<PrestamoDTO>();
		for (Prestamo prestamo : listaPrestamos) {
			PrestamoDTO prestamoDTO = PrestamoDTO.convertToDTO(prestamo, clienteDTO);
			listaPrestamosDTO.add(prestamoDTO);
		}
		
		return listaPrestamosDTO;
	}	
}
