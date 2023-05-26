package com.example.demo.web.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.ClienteDireccionDTO;
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.DireccionService;

@Controller
public class DireccionController {
	
	private static final Logger log = LoggerFactory.getLogger(DireccionController.class);	
	
	@Autowired
	private DireccionService direccionService;	
	
	@Autowired
	private ClienteService clienteService;		
	
	@GetMapping("/clientes/{idCliente}/direcciones")
	public ModelAndView findAllByCliente(@PathVariable Long idCliente) {
		
		log.info("DireccionController - findAllByCliente: Mostramos todas las direcciones del cliente " + idCliente);
		
		ModelAndView mav = new ModelAndView("direcciones");
		
		// Obtenemos el cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		List<ClienteDireccionDTO> listaClientesDireccionesDTO = direccionService.findAllByCliente(clienteDTO);
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("listaClientesDireccionesDTO", listaClientesDireccionesDTO);
		
		return mav;		
	}
	
	// Añadir
	@GetMapping("/clientes/{idCliente}/direcciones/add")
	public ModelAndView add(@PathVariable Long idCliente) {

		log.info("DireccionController - add: Muestra la pantalla para añadir direccion");
		
		ModelAndView mav = new ModelAndView("direccionform");
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("direccionDTO", new DireccionDTO());
		mav.addObject("add", Integer.valueOf(1));
		
		return mav;
	}
	
	// Salvar
	@PostMapping("/clientes/{idCliente}/direcciones/save")
	public ModelAndView save(@ModelAttribute("direccionDTO") DireccionDTO direccionDTO,
			@PathVariable("idCliente") Long idCliente) {
		
		log.info("DireccionController - save:Salvamos los datos del DireccionDTO");	
		
		ModelAndView mav = new ModelAndView();
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
				
		// Relacionamos los dos objetos, direccion y cliente mediante ClienteDireccion.
		ClienteDireccionDTO cdDTO = new ClienteDireccionDTO();
		cdDTO.setClienteDTO(clienteDTO);
		cdDTO.setDireccionDTO(direccionDTO);
		// Creamos un timestamp
		Timestamp ts = Timestamp.from(Instant.now());
		cdDTO.setFechaAlta(ts);
		
		clienteDTO.getListaClientesDireccionesDTO().add(cdDTO);
		direccionDTO.getListaClientesDTO().add(clienteDTO);
		
		direccionService.save(direccionDTO, cdDTO);
		
		mav.setViewName("redirect:/clientes/{idCliente}/direcciones");
		return mav;
	}	

	
	
}
