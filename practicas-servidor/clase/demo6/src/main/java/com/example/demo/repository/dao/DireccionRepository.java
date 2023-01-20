package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Direccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DireccionRepository extends JpaRepository<Direccion, Long>{
	
	@Query(value = "SELECT A.* FROM direcciones A, clientesdirecciones B "
			+ "WHERE A.id = B.iddireccion and B.idcliente = :p1", nativeQuery=true)
	public List<Direccion> findAllByCliente(@Param("p1") Long idCliente);

}
