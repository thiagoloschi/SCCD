package br.superdia.sessionbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.jws.WebService;
import javax.ws.rs.Path;

import br.superdia.modelo.Produto;
import br.superdia.modelo.Usuario;
import br.superdia.modelo.Venda;

/*
 * Define os métodos que serão utilizados para implementar a lógica do carrinho de 
 * compras da aplicação.
 */

@Stateful
@Remote(ICarrinho.class)
@WebService
@Path("/cliente/carrinho")
public class CarrinhoBean implements ICarrinho {
	private List<Produto> produtos = new ArrayList<>();
	
	public void addProduct(Produto produto) {
		produtos.add(produto);
	}

	public void removeProduct(Produto produto) {
		produtos.removeIf( p -> p.getId() == produto.getId());
	}

	public void clearItens() {
		produtos.clear();		
	}
	
	public List<Produto> getItens() {
		return produtos;
	}

	public void endsBuy(Usuario usuario) {
		Venda venda = new Venda();
		venda.setData(Calendar.getInstance());
		venda.setUsuario(usuario);
		venda.setProdutos(produtos);
		DAOBean<Venda> dao = new DAOBean<>();
		dao.add(venda);
		clearItens();
	}
}
