package com.example.demo.repository.dao;

import java.util.List;

import com.example.demo.repository.entity.Cliente;

public interface ClienteRepository {
	void save(Cliente cliente);
	Cliente findById(Cliente cliente);
	List<Cliente> findAll();
	Cliente delete(Cliente cliente);
}
