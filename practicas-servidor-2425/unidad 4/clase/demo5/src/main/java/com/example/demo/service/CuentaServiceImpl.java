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
public class CuentaServiceImpl implements CuentaService{

	private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO) {
		
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		List<Cuenta> listaCuentas = cuentaRepository.findAllByCliente(cliente);
		if (listaCuentas.size()>0) {
			cliente = listaCuentas.get(0).getCliente();
			clienteDTO = ClienteDTO.convertToDTO(cliente);
		}
		
		List<CuentaDTO> listaCuentasDTO = new ArrayList<CuentaDTO>();
		for (int i = 0; i < listaCuentas.size(); i++) {
			Cuenta cuenta = listaCuentas.get(i);
			
			CuentaDTO cuentaDTO = CuentaDTO.convertToDTO(cuenta, clienteDTO);
			listaCuentasDTO.add(cuentaDTO);
		}		
			
		return listaCuentasDTO;
	}

	@Override
	public void delete(CuentaDTO cuentaDTO) {
		
		//ClienteDTO clienteDTO = clienteService.findById(cuentaDTO.getClienteDTO());
		
		Cuenta cuenta = CuentaDTO.convertToEntity(cuentaDTO);
		
		cuentaRepository.delete(cuenta);
	}
}
