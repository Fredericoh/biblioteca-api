package br.com.faculdadedelta.bibliotecaapi.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.faculdadedelta.bibliotecaapi.model.Usuario;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 3684333649668333106L;

	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}
}
