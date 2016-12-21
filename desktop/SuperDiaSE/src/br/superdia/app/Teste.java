package br.superdia.app;

import br.superdia.webservice.UserService;
import br.superdia.webservice.UserServiceService;
import br.superdia.webservice.Usuario;

public class Teste {

	public static void main(String[] args) {
		UserServiceService service = new UserServiceService();
		UserService userClient = service.getUserServicePort();
		
		Usuario usuario = new Usuario();
		usuario.setSenha("saw");
		usuario.setUsuario("saw");
		System.out.println(userClient.obtemUsuario(usuario).getPerfil());
		
	}

}
