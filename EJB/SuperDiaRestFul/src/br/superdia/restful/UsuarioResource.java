package br.superdia.restful;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.superdia.message.RespostasJSON;
import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.IDAO;

@Path("usuarios")
public class UsuarioResource {
	private Gson gson = new Gson();
	
	@EJB
	private IDAO<Usuario> dao;

	public UsuarioResource() {
	}
	
	@Path("inserir")
	@POST
	@Consumes("application/json")
	public void addUser(String user){
		Usuario u = gson.fromJson(user, Usuario.class);
		dao.add(u);
	}
	
	@Path("autenticar")
	@POST
	@Consumes("application/json")
	public String autenticar(String user){
		Usuario u = gson.fromJson(user, Usuario.class);
		u = dao.authenticate(u);
		if(u != null)
			return gson.toJson(u);
		else
			return gson.toJson(RespostasJSON.ERRO_USUARIO_INVALIDO.getMensagem());
	}
	
	@Path("obter")
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String getUserToken(String user){
		return "";
	}
}//class UsuarioResource
