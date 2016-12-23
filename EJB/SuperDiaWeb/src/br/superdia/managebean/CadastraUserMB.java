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
public class CadastraUserMB {
	@EJB
	private IDAO<Usuario> iUsuario;
	
	private Usuario usuario = new Usuario();
	
	private String senha2;
	
	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public void addUsuario(){
		if(usuario.getId()==null)
			iUsuario.add(usuario);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String cadastrarCliente(){
	
		// Verifica se as duas senhas batem.
		if(senha2.equalsIgnoreCase(usuario.getSenha())){
			
			usuario.setPerfil("cliente");
			iUsuario.add(usuario);
			
			usuario = new Usuario();
			
			return "login";
			
		}
		
		return "cadastrarCliente";
		
	}
	
}
