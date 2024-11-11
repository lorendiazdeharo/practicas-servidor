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
import com.example.demo.service.CuentaService;

@Controller
public class CuentaController {

	private static final Logger log = LoggerFactory.getLogger(CuentaController.class);

	@Autowired
	private CuentaService cuentaService;

// Visualizar la lista de cuentas
	@GetMapping("/clientes/{idCliente}/cuentas")
	public ModelAndView findAllByCliente(@PathVariable("idCliente") Long idCliente) {

		log.info("CuentaController - findAllByCliente: Mostramos la lista de cuentas del cliente:" + idCliente);

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		List<CuentaDTO> listaCuentasDTO = cuentaService.findAllByCliente(clienteDTO);

		ModelAndView mav = new ModelAndView("cuentas");
		if (listaCuentasDTO.size() > 0) {
			mav.addObject("clienteDTO", listaCuentasDTO.get(0).getClienteDTO());
		}

		mav.addObject("listaCuentasDTO", listaCuentasDTO);

		return mav;
	}
	
	// Borrar una cuenta
	@GetMapping("/clientes/{idCliente}/cuentas/delete/{idCuenta}")
	public ModelAndView delete(@PathVariable("idCliente") Long idCliente, @PathVariable("idCuenta") Long idCuenta) {
		
		log.info("CuentaController - delete: Borramos la cuenta:" + idCuenta);
		
		// Creamos una cuenta y le asignamos el id. Esta cuenta es el que se va a borrar
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setId(idCuenta);
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		cuentaDTO.setClienteDTO(clienteDTO);
		
		cuentaService.delete(cuentaDTO);
		
		// Redireccionamos para volver a invocar al metodo que escucha /cuentas
		ModelAndView mav = new ModelAndView("redirect:/cuentas");
		
		return mav;
	}		

}
