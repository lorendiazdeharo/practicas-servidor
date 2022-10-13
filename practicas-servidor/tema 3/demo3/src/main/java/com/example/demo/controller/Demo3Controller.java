package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Alumno;

@Controller
public class Demo3Controller {
	
	private static final Logger loggerController = LoggerFactory.getLogger(Demo3Controller.class);
	
	@GetMapping("/")
	public String index(Model model) {
		loggerController.info("Devuelve la página de index");
		model.addAttribute("objetoAlumno", new Alumno());
		return "index";
	}
	
	@PostMapping("/altaAlumno")
	public String altaAlumnoSubmit(@ModelAttribute Alumno alumno) {
		loggerController.info(alumno.toString());
		return "helloAlumno";
	}	
	
	/*
	 * Duplica el objeto que llega por el ModelAttribute y por el model
	 *
	@PostMapping("/altaAlumno")
	public String altaAlumnoSubmit(@ModelAttribute Alumno alumno, Model model) {
		loggerController.info(alumno.toString());
		model.addAttribute("alumnoOk", alumno);
		return "helloAlumno";
	}

*/
}
