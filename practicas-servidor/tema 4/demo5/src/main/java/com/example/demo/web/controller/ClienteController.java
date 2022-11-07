package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("/clientes/new")
	public ModelAndView newCliente() {
		log.info("ClienteController - newCliente: Mostramos la pagina de creacion de cliente");
		
	    ModelAndView mav = new ModelAndView("clienteForm");
	    ClienteDTO clienteDTO = new ClienteDTO();
	    mav.addObject("clienteDTO", clienteDTO);
	    mav.addObject("add", true);
	    
	    return mav;		
	}
	
	@PostMapping("/clientes/save")
	public ModelAndView saveCliente(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO) {
		log.info("ClienteController - saveCliente: Salvamos los datos del cliente y mostramos de nuevo la lista de clientes");
	    
	    // Invocamos a la capa de servicios para que almacene los datos del cliente
	    clienteService.save(clienteDTO);
	    		
		// Redireccionamos para volver a invocar al metodo que escucha /clientes
	    ModelAndView mav = new ModelAndView("redirect:/clientes");	    	    
	    return mav;		
	}	
	
	@GetMapping("/clientes/{idCliente}")
	public ModelAndView showClienteById(@PathVariable Long idCliente) {
		
		log.info("ClienteController - showClienteById: obtenemos el cliente con id: " + String.valueOf(idCliente));
		
	    ModelAndView mav = new ModelAndView("clienteShow");
	    
	    // Obtenemos el cliente y lo pasamos al modelo
	    ClienteDTO clienteDTO = new ClienteDTO();
	    clienteDTO.setId(idCliente);
	    clienteDTO = clienteService.findById(clienteDTO);
	    mav.addObject("clienteDTO", clienteDTO);
	    
	    return mav;
	}
	
	@GetMapping("/clientes")
	public ModelAndView getClientes() {
		log.info("ClienteController - getClientes: obtenemos la lista de clientes");
		
	    ModelAndView mav = new ModelAndView("clientes");	    
	    List<ClienteDTO> lista = clienteService.findAll();
	    mav.addObject("listaClientes", lista);
	    
	    return mav;		
	}
	
	@GetMapping("/clientes/update/{idCliente}")
	public ModelAndView updateCliente(@PathVariable Long idCliente) {
		
		log.info("ClienteController - updateCliente: actualizamos el cliente " + String.valueOf(idCliente));
		
	    ModelAndView mav = new ModelAndView("clienteForm");
	    
	    // Obtenemos el cliente y lo pasamos al modelo para ser actualizado
	    ClienteDTO clienteDTO = new ClienteDTO();
	    clienteDTO.setId(idCliente);
	    clienteDTO = clienteService.findById(clienteDTO);
	    mav.addObject("clienteDTO", clienteDTO);
	    mav.addObject("add", false);
	    
	    return mav;
	}	
	
	@GetMapping("/clientes/delete/{idCliente}")  
	public ModelAndView deleteCliente(@PathVariable Long idCliente)  {  
		
		log.info("ClienteController - deleteCliente: borramos el cliente " + String.valueOf(idCliente));
		
		// Redireccionamos para volver a invocar al metodo que escucha /clientes
	    ModelAndView mav = new ModelAndView("redirect:/clientes");
	    
	    // Creamos un cliente y le asignamos el id. Este cliente es el que se va a borrar
	    ClienteDTO clienteDTO = new ClienteDTO();
	    clienteDTO.setId(idCliente);
	    clienteDTO = clienteService.delete(clienteDTO);
	    mav.addObject("clienteDTO", clienteDTO);
	    
	    return mav;
	}  	
}
