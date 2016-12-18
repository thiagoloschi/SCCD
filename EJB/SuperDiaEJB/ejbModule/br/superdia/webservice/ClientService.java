package br.superdia.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.superdia.modelo.Produto;
import br.superdia.sessionbean.ICarrinho;
import br.superdia.sessionbean.IDAO;

@Stateless
@WebService
@Path("/clientservice")
public class ClientService {
	
	@EJB
	private IDAO<Produto> produtosDao;
	
	@EJB
	private ICarrinho carrinho;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/produtosall")
	public List<Produto> getProdutos(){
		List<Produto> produtos = produtosDao.getAll(Produto.class);
		return produtos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/carrinhoall")
	public List<Produto> getCarrinho(){
		return carrinho.getItens();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/carrinho/add/{id}")
	public String addProdutoCarrinho(@PathParam("id") Long id){
		try {
			Produto produto = produtosDao.getForId(id, Produto.class);
			carrinho.addProduct(produto);
		} catch (Exception e) {
			return "ERRO";
		}
			return "OK";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/carrinho/remove/{id}")
	public String removeProdutoCarrinho(@PathParam("id") Long id){
		try {
			Produto produto = produtosDao.getForId(id, Produto.class);
			carrinho.removeProduct(produto);
		} catch (Exception e) {
			return "ERRO";
		}
			return "OK";
	}
	
}