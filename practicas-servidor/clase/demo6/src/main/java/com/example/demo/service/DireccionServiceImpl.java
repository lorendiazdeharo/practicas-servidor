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
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.repository.dao.ClienteDireccionRepository;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.dao.CuentaRepository;
import com.example.demo.repository.dao.DireccionRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Cuenta;
import com.example.demo.repository.entity.Direccion;

@Service
public class DireccionServiceImpl implements DireccionService{
	
	private static final Logger log = LoggerFactory.getLogger(DireccionServiceImpl.class);		
	
	@Autowired
	private DireccionRepository direccionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteDireccionRepository clienteDireccionRepository;

	@Override
	public List<ClienteDireccionDTO> findAllByCliente(ClienteDTO clienteDTO) {
		log.info("DireccionServiceImpl - findAllByCliente: Mostramos todas las direcciones del cliente " + clienteDTO.toString());
		
		/*
		List<Direccion> listaDirecciones = direccionRepository.findAllByCliente(clienteDTO.getId());
		
		List<DireccionDTO> listaDireccionesDTO = new ArrayList<DireccionDTO>();
		for(int i=0; i<listaDirecciones.size(); i++) {
			listaDireccionesDTO.add(DireccionDTO.convertToDTO(listaDirecciones.get(i), clienteDTO));
		}
		
		return listaDireccionesDTO;
		*/
		
		List<ClienteDireccion> listaClientesDirecciones = clienteDireccionRepository.findAllByCliente(clienteDTO.getId());
		List<ClienteDireccionDTO> listaClientesDireccionesDTO = new ArrayList<ClienteDireccionDTO>();
		for(int i=0; i<listaClientesDirecciones.size(); i++) {
			listaClientesDireccionesDTO.add(ClienteDireccionDTO.convertToDTO(listaClientesDirecciones.get(i)));			
		}
		
		return listaClientesDireccionesDTO;		
	}

	@Override
	public void save(DireccionDTO direccionDTO, ClienteDireccionDTO cdDTO) {

		log.info("DireccionServiceImpl - save: Salvamos la direccion");

		// Obtenemos la entidad cliente
		Optional<Cliente> cliente = clienteRepository.findById(direccionDTO.getListaClientesDTO().get(0).getId());
		
		// Persistimos la entidad direccion
		Direccion direccion = DireccionDTO.convertToEntity(direccionDTO, cliente.get());
		direccionRepository.save(direccion);
		
		// Hay que almacenar la relacion intermedia, que es ClienteDireccion
		ClienteDireccion cd = new ClienteDireccion();
		cd.setCliente(cliente.get());
		cd.setDireccion(direccion);
		cd.setFechaAlta(cdDTO.getFechaAlta());
		//clienteDireccionRepository.save(cd);
		clienteDireccionRepository.save(cd);
	}	

}
