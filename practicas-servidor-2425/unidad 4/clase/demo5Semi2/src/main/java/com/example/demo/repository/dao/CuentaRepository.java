package com.example.demo.repository.dao;

import java.util.List;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Cuenta;

public interface CuentaRepository {

	List<Cuenta> findAllByCliente(Cliente cliente);

	void delete(Cuenta cuenta);

}
