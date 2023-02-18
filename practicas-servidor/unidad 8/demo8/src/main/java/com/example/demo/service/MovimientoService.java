package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.model.dto.MovimientoDTO;

public interface MovimientoService {

	public List<MovimientoDTO> findAllByCuenta(CuentaDTO cuentaDTO);

}
