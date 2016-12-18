package br.superdia.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.superdia.modelo.Produto;
import br.superdia.sessionbean.IDAO;

@Stateless
@Remote
@WebService
@Path("clientservice")
public class ClientService {
	
	@EJB
	private IDAO<Produto> produtosDao;
	
	@GET
	@Path("produtosall")
	public String getProdutos(){
		List<Produto> produtos = produtosDao.getAll(Produto.class);
		return produtos.toString();
	}
}
