package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// Listar
	@GetMapping("/clientes")
	public ModelAndView findAll() {
		
		log.info("ClienteController - findAll: Mostramos todos los clientes");
		
		ModelAndView mav = new ModelAndView("clientes");
		
		// Invocamos a la capa de servicio para que nos devuelva una lista de clientesDTO
		List<ClienteDTO> listaClientesDTO = null;
		listaClientesDTO = clienteService.findAll();
		
		mav.addObject("listaClientesDTO", listaClientesDTO);
		
		return mav;
	}
	
	// Añadir
	@GetMapping("/clientes/add")
	public ModelAndView add() {

		log.info("ClienteController - add: Muestra la pantalla para añadir cliente");
		
		ModelAndView mav = new ModelAndView("clienteform");
		mav.addObject("clienteDTO", new ClienteDTO());
		mav.addObject("add", Integer.valueOf(1));
		
		return mav;
	}
	
	// Salvar
	@PostMapping("/clientes/save")
	public ModelAndView save(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO) {
		
		log.info("ClienteController - save:Salvamos los datos del clienteDTO");	
		
		ModelAndView mav = new ModelAndView();

		boolean seguir =!clienteDTO.getNif().isEmpty() &&
				!clienteDTO.getNombre().isEmpty() &&
				!clienteDTO.getApellidos().isEmpty() &&
				!clienteDTO.getClaveSeguridad().isEmpty() &&
				!clienteDTO.getEmail().isEmpty();
				
		if(!seguir) {
			mav.addObject("clienteDTO", clienteDTO);
			mav.addObject("add", true);
			mav.addObject("errorMessage", "Algunos valores son vacios");
			mav.setViewName("clienteform");
		}else {
		
			clienteService.save(clienteDTO);
		
			mav.setViewName("redirect:/clientes");
		}
		return mav;
	}
	
	// Actualizar
	@GetMapping("/clientes/update/{idCliente}")
	public ModelAndView update(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteController - update: Actualizamos los datos del cliente " + idCliente);
		
		ModelAndView mav = new ModelAndView("clienteform");
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("add", Integer.valueOf(0));
		
		return mav;
	}
	
	// Borrar
	@GetMapping("/clientes/delete/{idCliente}")
	public ModelAndView delete(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteController - delete: Borramos el cliente " + idCliente);
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteService.delete(clienteDTO);

		ModelAndView mav = new ModelAndView("redirect:/clientes");
		return mav;				
	}
	
	
	// Buscar por id
	@GetMapping("/clientes/{idCliente}")
	public ModelAndView findById(@PathVariable("idCliente") Long idCliente) {
		
		log.info("ClienteController - findById: Mostramos los datos del cliente " + idCliente);
		
		ModelAndView mav = new ModelAndView("clienteshow");
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		mav.addObject("clienteDTO", clienteDTO);
		
		return mav;
	}
}
