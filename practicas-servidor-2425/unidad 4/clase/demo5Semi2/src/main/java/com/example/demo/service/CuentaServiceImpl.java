package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
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
public class CuentaServiceImpl implements CuentaService{

	private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);
	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO) {
		
		log.info("CuentaServiceImpl - findAllByCliente: Lista de todas las cuentas del cliente " 
				+ clienteDTO.getId());
		
		List<CuentaDTO> listaCuentasDTO = new ArrayList<CuentaDTO>();
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		
		List<Cuenta> listaCuentas = cuentaRepository.findAllByCliente(cliente);
		
		for (Cuenta cuenta : listaCuentas) {
			CuentaDTO cuentaDTO = CuentaDTO.convertToDTO(cuenta, clienteDTO);
			listaCuentasDTO.add(cuentaDTO);
		}
		
		return listaCuentasDTO;
	}

	@Override
	public void delete(CuentaDTO cuentaDTO) {
		log.info("CuentaServiceImpl - delete: Borramos la cuenta: " + cuentaDTO.getId() + " del cliente:" 
				+ cuentaDTO.getClienteDTO().getId());
		
		Cuenta cuenta = new Cuenta();
		cuenta.setId(cuentaDTO.getId());		
		Cliente cliente = new Cliente();
		cliente.setId(cuentaDTO.getClienteDTO().getId());
		
		cuenta.setCliente(cliente);
		
		cuentaRepository.delete(cuenta);
	}

}
