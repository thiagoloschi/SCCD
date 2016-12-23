package br.superdia.sessionbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.superdia.modelo.ItemVenda;
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
	private List<ItemVenda> itemVendas = new ArrayList<>();
	
	public void addProduct(ItemVenda itemVenda) {
		itemVendas.add(itemVenda);
	}

	public void removeProduct(ItemVenda itemVenda) {
		itemVendas.removeIf( p -> p.getProduto().getId() == itemVenda.getProduto().getId());
	}

	public void clearItens() {
		itemVendas.removeAll(itemVendas);
		itemVendas.clear();		
	}
	
	public List<ItemVenda> getItemVendas() {
		return itemVendas;
	}

	public void endsBuy(Usuario usuario) {
		DAOBean<Venda> dao = new DAOBean<>();
		Venda venda = new Venda();
		venda.setData(Calendar.getInstance());
		venda.setUsuario(usuario);
		venda.setProdutos(atualizaQuantidade());
		dao.add(venda);
		clearItens();
	}
	
	public List<ItemVenda> atualizaQuantidade(){
		DAOBean<Produto> dao = new DAOBean<>();
		this.itemVendas.forEach(p-> {
			p.getProduto().setQuantidadeEstoque(p.getProduto().getQuantidadeEstoque()-p.getQuantidade().intValue());
			dao.update(p.getProduto());
		});
		return this.itemVendas;
	}
	
}
