package com.example.demo.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Recomendacion;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository{
	
	private static List<Cliente> datos = new ArrayList<Cliente>();
	
	static {
		// Creamos 5 clientes
		Cliente c1 = new Cliente();
		c1.setId(Long.valueOf(datos.size()+1));
		c1.setNombre("Antonio");
		c1.setApellidos("Lopez");
		c1.setNif("11111111A");
		c1.setEmail("antonio.lopez@prueba.com");
		c1.setClaveSeguridad("12345");
		
		Recomendacion r1 = new Recomendacion();
		r1.setId(Long.valueOf(datos.size()+1));
		r1.setObservaciones("No tiene ninguna.");
		
		r1.setCliente(c1);
		c1.setRecomendacion(r1);
		
		datos.add(c1);
		
		Cliente c2 = new Cliente();
		c2.setId(Long.valueOf(datos.size()+1));
		c2.setNombre("Belen");
		c2.setApellidos("Cuenca");
		c2.setNif("22222222B");
		c2.setEmail("belen.cuenca@prueba.com");
		c2.setClaveSeguridad("67890");
		
		Recomendacion r2 = new Recomendacion();
		r2.setId(Long.valueOf(datos.size()+1));
		r2.setObservaciones("Muy recomendada");
		r2.setCliente(c2);
		c2.setRecomendacion(r2);
		datos.add(c2);
		
		Cliente c3 = new Cliente();
		c3.setId(Long.valueOf(datos.size()+1));
		c3.setNombre("Juan");
		c3.setApellidos("Pérez");
		c3.setNif("33333333C");
		c3.setEmail("juan.perez@prueba.com");
		c3.setClaveSeguridad("02468");
		
		Recomendacion r3 = new Recomendacion();
		r3.setId(Long.valueOf(datos.size()+1));
		r3.setObservaciones("Sin comentarios");
		r3.setCliente(c3);
		c3.setRecomendacion(r3);
		datos.add(c3);		
		
		Cliente c4 = new Cliente();
		c4.setId(Long.valueOf(datos.size()+1));
		c4.setNombre("María");
		c4.setApellidos("Rodríguez");
		c4.setNif("44444444D");
		c4.setEmail("maria.rodriguez@prueba.com");
		c4.setClaveSeguridad("13579");
		
		Recomendacion r4 = new Recomendacion();
		r4.setId(Long.valueOf(datos.size()+1));
		r4.setObservaciones("Le encanta The Mandalorian");
		r4.setCliente(c4);
		c4.setRecomendacion(r4);
		datos.add(c4);		
		
		Cliente c5 = new Cliente();
		c5.setId(Long.valueOf(datos.size()+1));
		c5.setNombre("Juan");
		c5.setApellidos("Gómez-Jurado");
		c5.setNif("55555555E");
		c5.setEmail("juan.gomez-jurado@prueba.com");
		c5.setClaveSeguridad("98765");
		
		Recomendacion r5 = new Recomendacion();
		r5.setId(Long.valueOf(datos.size()+1));
		r5.setObservaciones("Escritor famoso");
		r5.setCliente(c5);
		c5.setRecomendacion(r5);
		datos.add(c5);				
		
	}

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
			Long id = datos.get(datos.size() - 1).getId() + 1;
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
