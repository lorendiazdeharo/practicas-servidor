package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PrestamoDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.PrestamoService;

@Controller
public class PrestamoController {
	
	private static final Logger log = LoggerFactory.getLogger(PrestamoController.class);
	
	@Autowired
	private PrestamoService prestamoService;	
	
	@Autowired
	private ClienteService clienteService;		
	
	@GetMapping("/clientes/{idCliente}/prestamos")
	public ModelAndView findAllByCliente(@PathVariable("idCliente") Long idCliente) {
		log.info("PrestamoController - findAllByCliente: Mostramos los prestamos del cliente:" + idCliente);
		
		// Obtenemos el cliente y lo pasamos al modelo
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		// Lista de prestamos
		List<PrestamoDTO> listaPrestamosDTO = prestamoService.findAllByCliente(clienteDTO);
		
		ModelAndView mav = new ModelAndView("prestamos");
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("listaPrestamosDTO", listaPrestamosDTO);
		
		return mav;		
	}

}
