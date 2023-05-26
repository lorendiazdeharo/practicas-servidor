package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.dao.CuentaRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService {

	private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;	

	@Override
	public List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO) {
		log.info("CuentaServiceImpl - finfindAllByClientedAll: Lista de todas las cuentas del cliente: "
				+ clienteDTO.getId());

		// Obtenemos la lista de cuentas del cliente
		List<Cuenta> lista = (List<Cuenta>) cuentaRepository.findAllByCliente(clienteDTO.getId());
		// Creamos una lista de CuentaDTO que será la que devolvamos al controlador
		List<CuentaDTO> listaResultadoDTO = new ArrayList<CuentaDTO>();
		// Recorremos la lista de cuentas y las mapeamos a DTO
		for (int i = 0; i < lista.size(); ++i) {
			listaResultadoDTO.add(CuentaDTO.convertToDTO(lista.get(i), clienteDTO));
		}
		// Devolvemos la lista de DTO's
		return listaResultadoDTO;
	}
	
	/* 
	 * Metodo 1 de borrado de un hijo en una relacion 1 a N: 
	 * ejecutamos directamente el borrado por medio del id
	 */
	@Override
	public void delete(CuentaDTO cuentaDTO) {
		log.info("CuentaServiceImpl - delete: Metodo 1: borramos la cuenta: " + cuentaDTO.toString());
 
		cuentaRepository.deleteById(cuentaDTO.getId());		
	}

	/* 
	 * Metodo 2 de borrado de un hijo en una relacion 1 a N: 
	 * ejecutamos directamente el borrado por medio del id
	 */
	@Override
	public void delete(CuentaDTO cuentaDTO, ClienteDTO clienteDTO) {
		log.info("CuentaServiceImpl - delete: Metodo 1: borramos la cuenta: " + cuentaDTO.toString());
		// Localizamos ambos objetos
		Optional<Cliente> cliente = clienteRepository.findById(clienteDTO.getId());
		Optional<Cuenta> cuenta = cuentaRepository.findById(cuentaDTO.getId());
		
		// Eliminamos la cuenta de la lista de cuentas del cliente. 
		// Con esto eliminamos la relacion y podemos borrar la cuenta
		cliente.get().getListaCuentas().remove(cuenta.get());
		
		// Eliminamos la cuenta
 		cuentaRepository.deleteById(cuenta.get().getId());
 		
 		// Salvamos el cliente con la nueva situacioni
		clienteRepository.save(cliente.get());
	}	

	@Override
	public void save(CuentaDTO cuentaDTO) {
		log.info("CuentaServiceImpl - save: salvamos la cuenta : " + cuentaDTO.toString());

		Cuenta cuenta = CuentaDTO.convertToEntity(cuentaDTO);
		// Seguimos sin tener la necesidad de buscarlo
		Cliente cliente = new Cliente();
		cliente.setId(cuentaDTO.getClienteDTO().getId());
		cuenta.setCliente(cliente);
 
		cuentaRepository.save(cuenta);
	}	
}
