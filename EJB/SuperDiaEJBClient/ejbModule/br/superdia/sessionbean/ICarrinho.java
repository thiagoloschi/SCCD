package br.superdia.sessionbean;

import java.util.List;

import br.superdia.modelo.ItemVenda;
import br.superdia.modelo.Usuario;

public interface ICarrinho {
	public void addProduct(ItemVenda itemVendas);
	public void removeProduct(ItemVenda itemVendas);
	public void clearItens();
	public List<ItemVenda> getItemVendas();
	public void endsBuy(Usuario usuario);
}
