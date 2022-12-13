package com.example.demo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;
	
	@Value("${asignatura}")
	private String nombreAsignatura;

	@GetMapping("/")
	public ModelAndView index() {
		
		log.info("IndexController - index: Mostramos la pagina inicial");
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("titulo", nombreAplicacion);
		mav.addObject("nombreAsignatura", nombreAsignatura);
		
		return mav;
	}
}
