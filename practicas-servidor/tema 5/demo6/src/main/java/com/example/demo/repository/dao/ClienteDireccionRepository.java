package com.example.demo.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.ClienteDireccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ClienteDireccionRepository extends JpaRepository<ClienteDireccion, Long>{
	
	@Query(value = "SELECT c FROM ClienteDireccion c WHERE c.cliente.id = :idc AND c.direccion.id = :idd")
	public Optional<ClienteDireccion> findAllByClienteDireccion(@Param("idc") Long idCliente, @Param("idd") Long idDireccion);	

	@Query(value = "SELECT c FROM ClienteDireccion c WHERE c.cliente.id = :idcliente")
	public List<ClienteDireccion> findAllByCliente(@Param("idcliente") Long idCliente);
}
