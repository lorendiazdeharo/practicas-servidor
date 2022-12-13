package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.repository.dao.CuentaRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService {

	private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);

	@Autowired
	private CuentaRepository cuentaRepository;

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
