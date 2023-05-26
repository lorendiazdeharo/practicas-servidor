package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Movimiento;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface  MovimientoRepository extends JpaRepository<Movimiento, Long>{

	@Query(value = "SELECT A.* FROM Movimientos A "
			+ " WHERE A.IDCUENTAORIGEN = :idCuenta OR A.IDCUENTADESTINO = :idCuenta", nativeQuery = true)
	public List<Movimiento> findAllByCuenta(@Param("idCuenta") Long idCuenta);		
}
