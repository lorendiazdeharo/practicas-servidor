package com.example.demo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.RolDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;

@Controller
public class UsuarioController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioService usuarioService;

	// Alta de usuarios
	@GetMapping("/register")
	public ModelAndView register() {
		log.info("UsuarioController - register: Mostramos la pantalla de registro");
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("usuarioDTO", new UsuarioDTO());
		// retornamos el ModelAndView
		return mav;
	}

	// Alamcenar usuarios
	@PostMapping("/users/save")
	public ModelAndView save(@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO, @RequestParam String[] roles) {

		log.info("UsuarioController - save: Salvamos los datos del usuario:" + usuarioDTO.toString());
		for (String param : roles) {
			RolDTO rolDTO = new RolDTO();
			rolDTO.setNombre(param);
			rolDTO.setUsuarioDTO(usuarioDTO);
			usuarioDTO.getRolesDTO().add(rolDTO);
		}

		// Invocamos a la capa de servicios para que almacene los datos del usuario
		usuarioService.save(usuarioDTO);

		// Redireccionamos para volver a invocar a la raiz
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
}
