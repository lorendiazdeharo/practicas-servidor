package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.model.dto.MovimientoDTO;
import com.example.demo.repository.dao.MovimientoRepository;
import com.example.demo.repository.entity.Movimiento;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	private static final Logger log = LoggerFactory.getLogger(MovimientoServiceImpl.class);

	@Autowired
	private MovimientoRepository movimientoRepository;

	@Override
	public List<MovimientoDTO> findAllByCuenta(CuentaDTO cuentaDTO) {

			log.info("MovimientoServiceImpl - findAllByCuenta: Lista de todos los movimientos de la cuenta: "
					+ cuentaDTO.getId());
			
			// Obtenemos la lista de movimiento
			List<Movimiento> lista = movimientoRepository.findAllByCuenta(cuentaDTO.getId());
			// Creamos una lista de MovimientoDTO que será la que devolvamos al controlador
			List<MovimientoDTO> listaMovimientosDTO = new ArrayList<MovimientoDTO>();
			// Recorremos la lista de direcciones y las mapeamos a DTO
			for (int i = 0; i < lista.size(); ++i) {
				listaMovimientosDTO.add(MovimientoDTO.convertToDTO(lista.get(i)));
			}
			// Devolvemos la lista de DTO's
			return listaMovimientosDTO;		
		}
	
	

}
