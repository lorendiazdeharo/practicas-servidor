package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Demo2Controller {

	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;
	
	// Definimos el objeto de log
	private static final Logger loggerController = LoggerFactory.getLogger(Demo2Controller.class);
	
	@GetMapping(value = "/helloModel")
	public String hello(Model model) {
		// Añadimos 2 atributos al model
		model.addAttribute("titulo", nombreAplicacion);				
		model.addAttribute("mensaje", "hola desde Thymeleaf con Model");
		
		loggerController.info("Hola desde thymeleaf con Model");
		// Retornamos la vista que mostrará los valores de los atributos
		return "helloView";
	}
	

	@GetMapping(value="/helloModelMap")
	public String hello(ModelMap map) {
		// Añadimos 2 atributos al mapa que tiene el model
		map.addAttribute("titulo", nombreAplicacion);
		map.addAttribute("mensaje", "hola desde Thymeleaf con ModelMap");
		
		loggerController.info("Hola desde thymeleaf con ModelMap");
		// Retornamos la vista que mostrará los valores de los atributos que estan en el mapa
		return "helloView";
	}
	
	@GetMapping(value="/helloModelAndView")
	//public ModelAndView hello() {  -- Podria llamarse como los anteriores métodos		
	public ModelAndView helloMAV() {
		// Creamos el objeto que contendra el model y la vista
		ModelAndView mav = new ModelAndView();
		
		// Añadimos los atributos como objetos
		mav.addObject("titulo", nombreAplicacion);
		mav.addObject("mensaje", "hola desde Thymeleaf con ModelAndView");
				
		loggerController.info("Hola desde thymeleaf con ModelAndView");
		// Asignamos la vista 
		mav.setViewName("helloView");
		//Retornamos el objeto ModelAndView
		return mav;		
	}	
}
