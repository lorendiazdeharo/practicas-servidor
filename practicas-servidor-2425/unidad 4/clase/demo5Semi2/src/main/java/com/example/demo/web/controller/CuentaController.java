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
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.CuentaService;

@Controller
public class CuentaController {

	private static final Logger log = LoggerFactory.getLogger(CuentaController.class);		
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private ClienteService clienteService;	
		
	// Mostrar todas las cuentas de un cliente
	@GetMapping("/clientes/{idCliente}/cuentas")
	public ModelAndView findAllByCliente(@PathVariable("idCliente") Long idCliente) {
		
		log.info("CuentaController - findAllByCliente: Mostramos todas las cuentas del cliente:" + idCliente);
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		List<CuentaDTO> listaCuentasDTO = cuentaService.findAllByCliente(clienteDTO);
		
		ModelAndView mav = new ModelAndView("cuentas");
		mav.addObject("listaCuentasDTO", listaCuentasDTO);
		mav.addObject("clienteDTO", clienteDTO);
		
		return mav;
	}
	
	@GetMapping("/clientes/{idCliente}/cuentas/{idCuenta}/delete")
	public ModelAndView delete(@PathVariable("idCliente") Long idCliente, @PathVariable("idCuenta") Long idCuenta) {
	
		log.info("CuentaController - delete: Borramos la cuenta: " + idCuenta + " del cliente: "+ idCliente);
		
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setId(idCuenta);
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		
		cuentaDTO.setClienteDTO(clienteDTO);
		
		cuentaService.delete(cuentaDTO);
		
		// Redireccionamos para volver a invocar el metodo que escucha /clientes/{idCliente}/cuentas
		ModelAndView mav = new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");		
		return mav;		
	}
}
