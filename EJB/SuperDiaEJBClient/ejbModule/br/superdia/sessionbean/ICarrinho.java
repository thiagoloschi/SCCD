package br.superdia.sessionbean;

import java.util.List;

import br.superdia.modelo.Produto;
import br.superdia.modelo.Usuario;

public interface ICarrinho {
	public void addProduct(Produto produto);
	public void removeProduct(Produto produto);
	public void clearItens();
	public List<Produto> getItens();
	public void endsBuy(Usuario usuario);
}
