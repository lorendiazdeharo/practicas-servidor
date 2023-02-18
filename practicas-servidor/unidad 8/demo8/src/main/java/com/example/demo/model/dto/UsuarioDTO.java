package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.repository.entity.Rol;
import com.example.demo.repository.entity.Usuario;

import lombok.Data;
import lombok.ToString;

@Data
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String password;

	@ToString.Exclude
	private List<RolDTO> rolesDTO;

	public UsuarioDTO() {
		super();
		this.rolesDTO = new ArrayList<RolDTO>();
	}

	// Convertir de entidad a DTO
	public static UsuarioDTO converToDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setPassword(usuario.getPassword());

		for (int i = 0; i < usuario.getRoles().size(); i++) {
			RolDTO rolDTO = RolDTO.converToDTO(usuario.getRoles().get(i), usuarioDTO);
			usuarioDTO.getRolesDTO().add(rolDTO);
		}

		return usuarioDTO;
	}

	public static Usuario convertToEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuarioDTO.getPassword()));

		for (int i = 0; i < usuarioDTO.getRolesDTO().size(); i++) {
			Rol rol = RolDTO.converToEntity(usuarioDTO.getRolesDTO().get(i), usuario);
			usuario.getRoles().add(rol);
		}

		return usuario;
	}
}
