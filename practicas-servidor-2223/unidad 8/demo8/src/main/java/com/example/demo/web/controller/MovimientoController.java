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
import com.example.demo.model.dto.ClienteDireccionDTO;
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.model.dto.MovimientoDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MovimientoService;

@Controller
public class MovimientoController {

	private static final Logger log = LoggerFactory.getLogger(MovimientoController.class);

	@Autowired
	private MovimientoService movimientoService;
	
	@Autowired
	private ClienteService clienteService;	
	
	@GetMapping("/clientes/{idCliente}/cuentas/{idCuenta}/movimientos")
	public ModelAndView findAllByCuenta(@PathVariable Long idCliente, @PathVariable Long idCuenta) {

		log.info("MovimientoController - findAllByCuenta: Listamos los movimientos del cliente: " + idCliente 
				+ " y de la cuenta: " + idCuenta);

		// Obtenemos el cliente para luego poner sus datos en la pantalla
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setId(idCuenta);
		cuentaDTO.setClienteDTO(clienteDTO);
		// Obtenemos la lista de movimientos
		List<MovimientoDTO> listaMovimientosDTO = movimientoService.findAllByCuenta(cuentaDTO);
		// Pasamos los datos al modelo
		ModelAndView mav = new ModelAndView("movimientos");
		mav.addObject("listaMovimientosDTO", listaMovimientosDTO);
		mav.addObject("clienteDTO", clienteDTO);
		// retornamos el ModelAndView
		return mav;
	}	

}
