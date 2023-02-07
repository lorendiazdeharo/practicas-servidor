package com.example.demo.repository.dao;

import java.util.List;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Prestamo;

public interface PrestamoRepository {

	List<Prestamo> findAllByCliente(Cliente cliente);

}
