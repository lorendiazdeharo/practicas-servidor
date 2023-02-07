package com.example.demo.repository.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomCuentaRepositoryImpl implements CustomCuentaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void saveCustom(Cuenta cuenta) {
		Optional<Cliente> cliente = clienteRepository.findById(cuenta.getCliente().getId());
		cuenta.setCliente(cliente.get());
		entityManager.persist(cuenta);		
	}
}
