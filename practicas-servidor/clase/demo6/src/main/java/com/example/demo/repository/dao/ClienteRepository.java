package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
