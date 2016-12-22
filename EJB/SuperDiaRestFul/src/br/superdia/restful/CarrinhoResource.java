package br.superdia.restful;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.superdia.modelo.ItemVenda;
import br.superdia.sessionbean.ICarrinho;

@Path("carrinho")
public class CarrinhoResource {
	private Gson gson = new Gson();
	private List<ItemVenda> itens = new ArrayList<>();
	
	@EJB
	private ICarrinho carrinho;
	
	@Path("inserir")
	@POST
	@Consumes("application/json")
	public void addItem(String item){
		ItemVenda itemVenda = gson.fromJson(item, ItemVenda.class);
		itens.add(itemVenda);
	}
	
	@Path("remover/{id}")
	@DELETE
	@Consumes("application/json")
	public void removeItem(final @PathParam("id") String id){
		itens.removeIf(i -> i.getId() == Long.valueOf(id));
	}
	
	@Path("listar")
	@GET
	@Produces("application/json")
	public String getAll(){
		return gson.toJson(itens.toString());
	}
}