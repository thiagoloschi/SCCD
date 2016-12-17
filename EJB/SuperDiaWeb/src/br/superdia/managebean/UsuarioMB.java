package br.superdia.managebean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.IDAO;

/**
 * Gerencia o cadastro do usuario.
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {
	@EJB
	private IDAO<Usuario> iUsuario;
	
	private Usuario usuario = new Usuario();
	
	public void addUsuario(){
		if(usuario.getId()==null)
			iUsuario.add(usuario);
	}
	
	public void login(){
		
	}
	
	public String logout(){
		
		return "login";
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
