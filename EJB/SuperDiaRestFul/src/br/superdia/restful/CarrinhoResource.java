package br.superdia.restful;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.superdia.modelo.Produto;
import br.superdia.sessionbean.ICarrinho;

@Path("carrinho")
public class CarrinhoResource {
	private Gson gson = new Gson();
	private List<Produto> produtos = new ArrayList<>();
	
	@EJB
	private ICarrinho carrinho;
	
	@Path("inserir")
	public void addProduct(String product){
		Produto p = gson.fromJson(product, Produto.class);
		produtos.add(p);
	}
}
