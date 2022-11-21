package com.example.demo.repository.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Prestamo;

@Repository
public class PrestamoRepositoryImpl implements PrestamoRepository{
	
	public static Long id = (long) 1;
	
	private static final Logger log = LoggerFactory.getLogger(PrestamoRepositoryImpl.class);

	@Override
	public List<Prestamo> findAllByCliente(Cliente cliente) {
		return cliente.getListaPrestamos();
	}
	

}
