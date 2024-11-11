package com.example.demo.repository.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Cuenta;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository{

	private static final Logger log = LoggerFactory.getLogger(CuentaRepositoryImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cuenta> findAllByCliente(Cliente cliente) {
		
		log.info("CuentaRepositoryImpl - findAllByCliente: Lista de todas las cuentas por el cliente:" + cliente.getId());
				
		cliente = clienteRepository.findById(cliente);
		return cliente.getListaCuentas();
	}

	@Override
	public void delete(Cuenta cuenta) {
		int posCliente = clienteRepository.findAll().indexOf(cuenta.getCliente());
		//int posCuenta = clienteRepository.findAll().get(posCliente).getListaCuentas().indexOf(cuenta);
		//clienteRepository.findAll().get(posCliente).getListaCuentas().remove(posCuenta);
		clienteRepository.findAll().get(posCliente).
			getListaCuentas().remove(cuenta);
	}	

}
