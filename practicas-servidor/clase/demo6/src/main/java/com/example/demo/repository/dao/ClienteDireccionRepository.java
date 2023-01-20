package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Direccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ClienteDireccionRepository extends JpaRepository<ClienteDireccion, Long>{

	@Query(value = "SELECT c FROM ClienteDireccion c WHERE c.cliente.id = :p1")
	public List<ClienteDireccion> findAllByCliente(@Param("p1") Long idCliente);

	@Query(value = "SELECT c FROM ClienteDireccion c WHERE c.cliente.id = :idCliente AND c.direccion.id = :idDireccion")
	public ClienteDireccion findByClienteDireccion(Long idCliente, Long idDireccion);
	
	
}
