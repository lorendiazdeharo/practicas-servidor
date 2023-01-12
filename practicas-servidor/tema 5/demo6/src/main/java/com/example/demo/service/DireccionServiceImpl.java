package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.ClienteDireccionDTO;
import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.repository.dao.ClienteDireccionRepository;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.dao.DireccionRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Direccion;

@Service
public class DireccionServiceImpl implements DireccionService {

	private static final Logger log = LoggerFactory.getLogger(DireccionServiceImpl.class);

	@Autowired
	private DireccionRepository direccionRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteDireccionRepository clienteDireccionRepository;	

	@Override
	public List<ClienteDireccionDTO> findAllByCliente(ClienteDTO clienteDTO) {

		log.info("DireccionServiceImpl - findAllByCliente: Lista de todas las direcciones del cliente: "
				+ clienteDTO.getId());

		/*
		// Obtenemos la lista de direcciones del cliente
		List<Direccion> lista = (List<Direccion>) direccionRepository.findAllByCliente(clienteDTO.getId());
		// Creamos una lista de DireccionDTO que será la que devolvamos al controlador
		List<DireccionDTO> listaDireccionesDTO = new ArrayList<DireccionDTO>();
		// Recorremos la lista de direcciones y las mapeamos a DTO
		for (int i = 0; i < lista.size(); ++i) {
			listaDireccionesDTO.add(DireccionDTO.convertToDTO(lista.get(i), clienteDTO));
		}
		// Devolvemos la lista de DTO's
		return listaDireccionesDTO;
		
		*/
		
		// Obtenemos la lista de direcciones del cliente
		List<ClienteDireccion> lista = clienteDireccionRepository.findAllByCliente(clienteDTO.getId());
		// Creamos una lista de DireccionDTO que será la que devolvamos al controlador
		List<ClienteDireccionDTO> listaClientesDireccionesDTO = new ArrayList<ClienteDireccionDTO>();
		// Recorremos la lista de direcciones y las mapeamos a DTO
		for (int i = 0; i < lista.size(); ++i) {
			listaClientesDireccionesDTO.add(ClienteDireccionDTO.convertToDTO(lista.get(i)));
		}
		// Devolvemos la lista de DTO's
		return listaClientesDireccionesDTO;		
		
		
	}

	@Override
	public void save(DireccionDTO direccionDTO) {

		log.info("DireccionServiceImpl - save: Salva la direccion del cliente: "
				+ direccionDTO.getListaClientesDTO().get(0).getId());

		// Solo hay un clienteDTO en la direccionDTO
		/*
		Optional<Cliente> cliente = clienteRepository.findById(direccionDTO.getListaClientesDTO().get(0).getId());
		if (cliente.isPresent()) {
			// Creamos las relaciones en las entidades
			Direccion direccion = DireccionDTO.convertToEntity(direccionDTO, cliente.get());
			cliente.get().getListaDirecciones().add(direccion);
			// Almacenamos la direccion, y por la relacion que tiene, almacenará la relacion
			// N a N
			direccionRepository.save(direccion);			
		} 
		*/
		
		// Solo hay un clienteDTO en la direccionDTO. En este caso tendremos que creare la
		// entidad ClienteDireccion y asignarle las relaciones.
		Optional<Cliente> cliente = clienteRepository.findById(direccionDTO.getListaClientesDTO().get(0).getId());
		if (cliente.isPresent()) {
			// Creamos las relaciones en las entidades
			Direccion direccion = DireccionDTO.convertToEntity(direccionDTO, cliente.get());
			direccionRepository.save(direccion);			
			Optional<ClienteDireccion> cdo = clienteDireccionRepository.findAllByClienteDireccion(cliente.get().getId(), direccion.getId()); 
			if(cdo.isPresent()) {
				ClienteDireccion cd = cdo.get();
				cd.setFechaAlta(new Date());
				clienteDireccionRepository.save(cd);
			}
		}		
	}
}
