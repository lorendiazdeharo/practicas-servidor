package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@Controller
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	// Listar los clientes
	@GetMapping("/clientes")
	public ModelAndView findAll(@AuthenticationPrincipal User user) {
		
		log.info("ClienteController - findAll: Mostramos todos los clientes");
		log.info("usuario que hizo login:" + user);
		ModelAndView mav = new ModelAndView("clientes");
		List<ClienteDTO> listaClientesDTO = clienteService.findAll();
		mav.addObject("listaClientesDTO", listaClientesDTO);
		
		return mav;
		
	}
	
	// Visualizar la informacion de un cliente
	@GetMapping("/clientes/{idCliente}")
	public ModelAndView findById(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteController - findById: Mostramos la informacion del cliente:" + idCliente);
		
		// Obtenemos el cliente y lo pasamos al modelo
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		ModelAndView mav = new ModelAndView("clienteshow");
		mav.addObject("clienteDTO", clienteDTO);
		
		return mav;
	}
	
	
	// Alta de clientes
	@GetMapping("/clientes/add")
	public ModelAndView add() {
		
		log.info("ClienteController - add: Anyadimos un nuevo cliente");
		
		ModelAndView mav = new ModelAndView("clienteform");
		mav.addObject("clienteDTO", new ClienteDTO());
		mav.addObject("add", true);
		
		return mav;
	}
	
	// Salvar clientes
	@PostMapping("/clientes/save")
	public ModelAndView save(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO) {
		
		log.info("ClienteController - save: Salvamos los datos del cliente:" + clienteDTO.toString());
		
		// Invocamos a la capa de servicios para que almacene los datos del cliente
		clienteService.save(clienteDTO);
		
		// Redireccionamos para volver a invocar el metodo que escucha /clientes
		ModelAndView mav = new ModelAndView("redirect:/clientes");		
		return mav;
	}
	
	// Actualizar la informacion de un cliente 
	@GetMapping("/clientes/update/{idCliente}")
	public ModelAndView update(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteController - update: Modificamos el cliente: " + idCliente);
		
		// Obtenemos el cliente y lo pasamos al modelo para ser actualizado
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);		
				
		ModelAndView mav = new ModelAndView("clienteform");
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("add", false);
		
		return mav;
	}	
	
	
	// Borrar un cliente
	@GetMapping("/clientes/delete/{idCliente}")
	public ModelAndView delete(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteController - delete: Borramos el cliente:" + idCliente);
		
		// Creamos un cliente y le asignamos el id. Este cliente es el que se va a borrar
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteService.delete(clienteDTO);
		
		// Redireccionamos para volver a invocar al metodo que escucha /clientes
		ModelAndView mav = new ModelAndView("redirect:/clientes");
		
		return mav;
	}	
	
}
