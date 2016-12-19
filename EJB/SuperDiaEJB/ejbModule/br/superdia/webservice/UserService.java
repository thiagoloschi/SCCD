package br.superdia.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.IUsuarioDAO;

@WebService
@Stateless
public class UserService {
	
	@EJB
	private IUsuarioDAO usuarioDAO;
	
	public Usuario obtemUsuario(Usuario usuario){
		Usuario result = usuarioDAO.getUser(usuario);
		return result;
	}
}
