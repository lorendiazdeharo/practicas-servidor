package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public List<ClienteDTO> findAll() {
		
		log.info("ClienteServiceImpl - findAll: Mostramos todos los clientes");

		// Invocar al repositorio que nos devuelva la lista de clientes
		List<Cliente> listaClientes;
		listaClientes = clienteRepository.findAll();
	
		List<ClienteDTO> listaClientesDTO = new ArrayList<ClienteDTO>();
		for(int i=0; i<listaClientes.size(); i++){
			Cliente cliente = listaClientes.get(i);
			ClienteDTO clienteDTO = ClienteDTO.convertToDTO(cliente);
			listaClientesDTO.add(clienteDTO);
		}
		
		return listaClientesDTO;
	}

	@Override
	public void save(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - save: Salva el cliente: " + clienteDTO.toString());
		Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
		clienteRepository.save(cliente);		
	}

	@Override
	public ClienteDTO findById(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - findById: Busca el cliente: " + clienteDTO.getId());
		// Paso de DTO a entidad		
		Optional<Cliente> cliente = clienteRepository.findById(clienteDTO.getId());
		
		// Paso de entidad a DTO
		log.info("ClienteServiceImpl - findById: Entidad cliente: " + cliente.toString());
		clienteDTO = ClienteDTO.convertToDTO(cliente.get());
		return clienteDTO;
		
	}

	@Override
	public void delete(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - delete: Borra el cliente: " + clienteDTO.getId());
		
		// Creo el objeto cliente y le asigno el id
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		// Borro la entidad				
		clienteRepository.delete(cliente);
		
	}

}
