package com.example.demo.service;

import java.util.List;
import java.util.Optional;
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
	public List<ClienteDTO> findAll() {		
		log.info("ClienteServiceImpl - findAll: Lista de todos los cliente");

		List<ClienteDTO> listaClientesDTO = clienteRepository.findAll()
				.stream()
				.map(p->ClienteDTO.convertToDTO(p))
				.collect(Collectors.toList());
		
		return listaClientesDTO;
	}

	@Override
	public ClienteDTO findById(ClienteDTO clienteDTO) {		
		log.info("ClienteServiceImpl - findById: Buscar cliente por id: " + clienteDTO.getId());
		
		Optional<Cliente> cliente = clienteRepository.findById(clienteDTO.getId());
		if(cliente.isPresent()) {
			clienteDTO = ClienteDTO.convertToDTO(cliente.get());
			return clienteDTO;
		}else {
			return null;
		}
	}

	@Override
	public void save(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - save: Salvamos el cliente: " + clienteDTO.toString());
		
		Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
		clienteRepository.save(cliente);
	}

	@Override
	public void delete(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - delete: Borramos el cliente: " + clienteDTO.getId());
		
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		clienteRepository.delete(cliente);
	}
}
