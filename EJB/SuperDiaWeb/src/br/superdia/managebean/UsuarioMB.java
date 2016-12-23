package br.superdia.managebean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.IDAO;
import br.superdia.sessionbean.IUsuarioDAO;
import br.superdia.utils.SessionUtil;

/**
 * Gerencia o cadastro do usuario.
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {
	@EJB
	private IDAO<Usuario> iUsuario;
	
	@EJB
	private IUsuarioDAO usuarioDAO;
	
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
	
	public String login(){
		boolean loginValido = usuarioDAO.isValid(usuario);
		if(loginValido){
			
			usuario = usuarioDAO.getUser(usuario);
			
			SessionUtil.setParam("USUARIOLogado", usuario);
			
			if(usuario.getPerfil().equalsIgnoreCase("adm"))
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
	
	public String cadastrarCliente(){
		
		// Verificar se o cliente ja existe no banco.
		//				...........
		
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
