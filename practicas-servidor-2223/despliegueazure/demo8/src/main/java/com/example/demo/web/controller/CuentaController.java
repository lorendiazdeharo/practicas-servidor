package com.example.demo.web.controller;

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

	@GetMapping("/clientes/{idCliente}/cuentas")
	public ModelAndView findAllByCliente(@PathVariable Long idCliente) {

		log.info("CuentaController - findAllByCliente: Mostramos todas las cuentas del cliente: " + idCliente);

		// Obtenemos el cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);

		// Obtenemos la lista de cuentas
		List<CuentaDTO> listaCuentasDTO = cuentaService.findAllByCliente(clienteDTO);

		ModelAndView mav = new ModelAndView("cuentas");
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("listaCuentasDTO", listaCuentasDTO);

		return mav;
	}
	
	// Borrar una cuenta
	@GetMapping("/clientes/{idCliente}/cuentas/{idCuenta}/delete")
	public ModelAndView delete(@PathVariable("idCliente") Long idCliente, 
			@PathVariable("idCuenta") Long idCuenta) {
		
		//log.info("CuentaController - delete: Usamos el metodo 1 para borrar la cuenta:" + idCuenta);
		log.info("CuentaController - delete: Usamos el metodo 2 para borrar la cuenta:" + idCuenta);		
				
		// Creamos el clienteDTO
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		
		// Creamos la cuentaDTO 
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setId(idCuenta);
		
		// Invocamos al metodo de borrar
		// cuentaService.delete(cuentaDTO);
		cuentaService.delete(cuentaDTO, clienteDTO);
				
		// Redireccionamos para volver a invocar al metodo que escucha /clientes
		ModelAndView mav = new ModelAndView("redirect:/clientes/{idCliente}/cuentas");
		
		return mav;
	}		

	@GetMapping("/clientes/{idCliente}/cuentas/add")
	public ModelAndView add(@PathVariable Long idCliente) {
		
		log.info("CuentaController - add: Alta de cuenta del cliente: " + idCliente);
		
		// Obtenemos el cliente para luego poner sus datos en la pantalla
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		// pasamos el cliente y la nueva cuenta a la vista
		ModelAndView mav = new ModelAndView("cuentaform");
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("cuentaDTO", new CuentaDTO());
		mav.addObject("add", true);
		return mav;
	}

	@PostMapping("/clientes/{idCliente}/cuentas/save")
	public ModelAndView save(@PathVariable Long idCliente, @ModelAttribute("cuentaDTO") CuentaDTO cuentaDTO) {
		
		log.info("CuentaController - save: Salvando la cuenta del cliente: " + idCliente);
		
		// Obtenemos el cliente para luego poner sus datos en la pantalla
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		// Asignamos a la cuenta el cliente (no hace falta buscarlo ya que al salvarlo lo buscaremos)
		cuentaDTO.setClienteDTO(clienteDTO);

		// invocamos la operacion save a la capa de servicio de cuenta
		cuentaService.save(cuentaDTO);
		// Retornamos a la lista de cuentas del cliente
		ModelAndView mav = new ModelAndView("redirect:/clientes/{idCliente}/cuentas");
		return mav;
	}
}
