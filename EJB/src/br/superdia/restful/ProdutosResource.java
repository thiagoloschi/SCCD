package br.superdia.restful;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.superdia.modelo.Produto;
import br.superdia.sessionbean.IDAO;

@Path("produtos")
public class ProdutosResource {
	private Gson gson = new Gson();
	
	@EJB
	private IDAO<Produto> dao;

	public ProdutosResource() {
	}
	
	//http://localhost:8080/SuperDiaRestFul/rest/produtos/listar
	@Path("listar")
	@GET
	@Produces("application/json")
	public String getAll(){
		return gson.toJson(dao.getAll(Produto.class));
	}
	
	@Path("produto/{id}")
	@GET
	@Produces("application/json")
	public String getById(final @PathParam("id") String id){
		System.out.println("Meu id: " + id);
		return gson.toJson(dao.getForId(Long.valueOf(id), Produto.class));
	}
}
