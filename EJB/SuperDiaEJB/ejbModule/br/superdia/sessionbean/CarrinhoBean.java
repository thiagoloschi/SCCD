package br.superdia.sessionbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.superdia.modelo.Produto;
import br.superdia.modelo.Usuario;
import br.superdia.modelo.Venda;

/*
 * Define os métodos que serão utilizados para implementar a lógica do carrinho de 
 * compras da aplicação.
 */

@Stateful
@Remote(ICarrinho.class)
public class CarrinhoBean implements ICarrinho {
	private List<Produto> produtos = new ArrayList<>();
	
	public void addProduct(Produto produto) {
		produtos.add(produto);
	}

	public void removeProduct(Produto produto) {
		
		System.err.println("\n\n\nFora do loop: " + produtos.toString() + "\n\n\n");
		
		for(int contador = 0; contador < produtos.size(); contador++)
			if(produto.getId() == produtos.get(contador).getId()){
				produtos.remove(contador);
				break;
			}
		//produtos.removeIf( p -> p.getNome().equalsIgnoreCase(produto.getNome()) );
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
