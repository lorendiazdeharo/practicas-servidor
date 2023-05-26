package com.example.demo.repository.dao;

import java.util.List;

import com.example.demo.repository.entity.Cliente;

public interface ClienteRepository {

	List<Cliente> findAll();
	Cliente findById(Cliente cliente);
	void save(Cliente cliente);
	void delete(Cliente cliente);

}
