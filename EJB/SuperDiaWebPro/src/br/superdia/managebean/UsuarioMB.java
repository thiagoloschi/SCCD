package br.superdia.managebean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.superdia.modelo.Perfil;
import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.IUsuarioDAO;
import br.superdia.utils.SessionUtil;

/**
 * Gerencia o cadastro do usuario.
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {
	
	@EJB
	private IUsuarioDAO usuarioDAO;
	
	private Usuario usuario = new Usuario();
	
	public String login(){
		boolean loginValido = usuarioDAO.isValid(usuario);
		if(loginValido){
			
			usuario = usuarioDAO.getUser(usuario);
			
			SessionUtil.setParam("USUARIOLogado", usuario);
			
			if(usuario.getPerfil().equalsIgnoreCase(Perfil.ADMINISTRADOR.getPerfil()))
				return "controleEstoque";
			else
				return "produtos";
			
		}
		else {
			usuario = new Usuario();
			return "login";
		}			
	}
	
	public String logout(){
		
		SessionUtil.remove("USUARIOLogado");
		SessionUtil.invalidate();
		
		return "login";	
	}
	
	public boolean isLogado(){
		return usuario.getUsuario() != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
