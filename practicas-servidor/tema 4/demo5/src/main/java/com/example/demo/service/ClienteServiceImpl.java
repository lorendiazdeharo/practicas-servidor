package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);		
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void save(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - save: Salvamos los datos del cliente: " + clienteDTO.toString());
		
		Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
		clienteRepository.save(cliente);		
	}

	@Override
	public ClienteDTO findById(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - findById: Buscamos el cliente: " + clienteDTO.toString());
		
		Cliente cliente = clienteRepository.findById(ClienteDTO.convertToEntity(clienteDTO));
		if(cliente!=null) {
			return ClienteDTO.convertToDTO(cliente);
		}else {
			return null;
		}
	}

	@Override
	public List<ClienteDTO> findAll() {
		log.info("ClienteServiceImpl - findAll: Lista de todos los clientes");
		
		/*
		List<Cliente> listaClientes = clienteRepository.findAll();
		List<ClienteDTO> listaClientesDTO = new ArrayList<ClienteDTO>();
		for(int i=0; i<listaClientes.size();i++) {
			listaClientesDTO.add(ClienteDTO.convertToDTO(listaClientes.get(i)));
		}
		return listaClientesDTO;
		
		*/
		/* 
		 * IMPLEMENTADO CON FUNCIONES LAMBDA
		
		*/
		List<ClienteDTO> listaClientesDTO = clienteRepository.findAll()
				.stream()
				.map(p->ClienteDTO.convertToDTO(p))
				.collect(Collectors.toList());
		return listaClientesDTO;
	}

	@Override
	public ClienteDTO delete(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - delete: Borramos el cliente: " + clienteDTO.toString());
		
		Cliente a = clienteRepository.delete(ClienteDTO.convertToEntity(clienteDTO));
		return ClienteDTO.convertToDTO(a);
	}

}
