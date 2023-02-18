package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Direccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

	@Query(value = "SELECT A.* FROM DIRECCIONES A, CLIENTESDIRECCIONES B "
			+ " WHERE A.ID=B.IDDIRECCION AND B.IDCLIENTE = :idcliente", nativeQuery = true)
	public List<Direccion> findAllByCliente(@Param("idcliente") Long idCliente);	
	
}
