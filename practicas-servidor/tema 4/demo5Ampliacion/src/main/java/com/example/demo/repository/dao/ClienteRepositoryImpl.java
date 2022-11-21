package com.example.demo.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Recomendacion;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository{
	
	public static List<Cliente> datos = new ArrayList<Cliente>();
	public static InicializacionBD bd = new InicializacionBD();

	@Override
	public List<Cliente> findAll() {
		return datos;
	}

	@Override
	public Cliente findById(Cliente cliente) {
		int posicion = datos.indexOf(cliente);
		return datos.get(posicion);
	}

	@Override
	public void save(Cliente cliente) {
		if(cliente.getId() != null) {
			int posicion = datos.indexOf(cliente);
			datos.set(posicion, cliente);			
		}else {
			// Inicializamos el valor del id en caso de que no tenga dartos
			Long id = Long.valueOf(1);
			// Comprobamos que tiene datos para asignar un nuevo id. Si no tiene se asigna 1
			if(datos.size()>0) {
				id = datos.get(datos.size() - 1).getId() + 1;
			}
			cliente.setId(id);
			cliente.getRecomendacion().setId(id);
			datos.add(cliente);
		}
	}

	@Override
	public void delete(Cliente cliente) {
		int posicion = datos.indexOf(cliente);
		datos.remove(posicion);		
	}

}
