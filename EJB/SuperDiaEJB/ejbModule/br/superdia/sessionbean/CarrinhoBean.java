package br.superdia.sessionbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.jws.WebService;
import javax.ws.rs.Path;

import br.superdia.modelo.ItemVenda;
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
	private List<ItemVenda> itemVendas = new ArrayList<>();
	
	public void addProduct(ItemVenda itemVenda) {
		itemVendas.add(itemVenda);
	}

	public void removeProduct(ItemVenda itemVenda) {
		itemVendas.removeIf( p -> p.getId() == itemVenda.getProduto().getId());
	}

	public void clearItens() {
		itemVendas.clear();		
	}
	
	public List<ItemVenda> getItemVendas() {
		return itemVendas;
	}

	public void endsBuy(Usuario usuario) {
		Venda venda = new Venda();
		venda.setData(Calendar.getInstance());
		venda.setUsuario(usuario);
		venda.setProdutos(geraItensVendas(venda));
		DAOBean<Venda> dao = new DAOBean<>();
		dao.add(venda);
		clearItens();
	}
	
	private List<ItemVenda> geraItensVendas(Venda venda){
		itemVendas.forEach(p -> {p.setVenda(venda);});
		return itemVendas;
	}
	
}
