package com.example.demo.web.webservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/ws")
public class ClienteRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteRestController.class);

	@Autowired
	private ClienteService clienteService;
	
	// Listar los clientes
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> findAll(@RequestParam(value = "apellidos", defaultValue = "") String apellidos) {
		
		List<ClienteDTO> listaClientesDTO = null;
		if(apellidos.isBlank()) {
			log.info("ClienteRestController - findAll: Mostramos todos los clientes");
			listaClientesDTO = clienteService.findAll();
		}else {
			log.info("ClienteRestController - findAll: Mostramos los clientes con apellidos " + apellidos);
			listaClientesDTO = clienteService.findByApellidos(apellidos);
		}
		
		return new ResponseEntity<>(listaClientesDTO, HttpStatus.OK);
	}	
	
	// Localizamos un cliente por id
	@GetMapping("/clientes/{idCliente}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteRestController - findById: Localizamos el cliente con id:" + idCliente);
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		if(clienteDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
		}
	} 
	
	// Alta de clientes
	@PostMapping("/clientes")
	public ResponseEntity<ClienteDTO> add(@RequestBody ClienteDTO clienteDTO) {
		
		log.info("ClienteRestController - add: Anyadimos un nuevo cliente");
		
		clienteDTO = clienteService.save(clienteDTO);
		if(clienteDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
		}
	}
	
	// Actualizacion de clientes
	@PutMapping("/clientes")
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO) {
		
		log.info("ClienteRestController - update: Modificamos el cliente: " + clienteDTO.getId());
		
		// Obtenemos el cliente para verificar que existe
		ClienteDTO clienteExDTO = new ClienteDTO();
		clienteExDTO.setId(clienteDTO.getId());
		clienteExDTO = clienteService.findById(clienteExDTO);
		
		if(clienteExDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			clienteDTO = clienteService.save(clienteDTO);
			return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
		}
	}	
	
	// Borrar un cliente
	@DeleteMapping("/clientes/{idCliente}")
	public ResponseEntity<String> delete(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteRestController - delete: Borramos el cliente:" + idCliente);
		
		// Creamos un cliente y le asignamos el id. Este cliente es el que se va a borrar
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteService.delete(clienteDTO);
		
		return new ResponseEntity<>("Cliente borrado satisfactoriamente", HttpStatus.OK);		
	}		
}
