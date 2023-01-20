package com.example.demo.repository.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomCuentaRepositoryImpl implements CustomCuentaRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveCustom(Cuenta cuenta) {
		
		// Haria cosas
		em.persist(cuenta);
		
	}

}
