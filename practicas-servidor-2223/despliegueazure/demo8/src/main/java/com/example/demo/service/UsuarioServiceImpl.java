package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repository.dao.UsuarioRepository;
import com.example.demo.repository.entity.Rol;
import com.example.demo.repository.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("UsuarioServiceImpl - loadUserByUsername: " + username);

		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario != null) {
			List<GrantedAuthority> listaPermisos = new ArrayList<GrantedAuthority>();
			List<Rol> listaRoles = new ArrayList<Rol>(usuario.getRoles());
			for (Rol rol : listaRoles) {
				listaPermisos.add(new SimpleGrantedAuthority(rol.getNombre()));
			}

			return new User(usuario.getUsername(), usuario.getPassword(), listaPermisos);
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

	@Override
	public void save(UsuarioDTO usuarioDTO) {
		log.info("UsuarioServiceImpl - save: salvamos el usuario : " + usuarioDTO.toString());

		Usuario usuario = UsuarioDTO.convertToEntity(usuarioDTO);

		usuarioRepository.save(usuario);

	}

}
