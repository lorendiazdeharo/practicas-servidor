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
import com.example.demo.repository.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);		
	
	@Autowired
	private CuentaRepository cuentaRepository;	

	@Override
	public List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO) {
		
		log.info("CuentaServiceImpl - findAllByCliente: Mostramos todas las cuentas del cliente " + clienteDTO.toString());
		
		List<Cuenta> listaCuentas = cuentaRepository.findAllByCliente(clienteDTO.getId());
		
		List<CuentaDTO> listaCuentasDTO = new ArrayList<CuentaDTO>();
		for(int i=0; i<listaCuentas.size(); i++) {
			listaCuentasDTO.add(CuentaDTO.convertToDTO(listaCuentas.get(i), clienteDTO));
		}
		
		return listaCuentasDTO;
	}

}
