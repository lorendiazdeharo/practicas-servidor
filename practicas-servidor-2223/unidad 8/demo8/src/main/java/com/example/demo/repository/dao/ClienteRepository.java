package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import com.example.demo.repository.entity.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query(value = "SELECT c FROM Cliente c WHERE c.apellidos = :apc")
	List<Cliente> findByApellidos(@Param("apc") String apellidos);	
}
