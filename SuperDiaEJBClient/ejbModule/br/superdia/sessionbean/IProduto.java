package br.superdia.sessionbean;

import java.util.List;

import br.superdia.modelo.Produto;

public interface IProduto {
	public void add(Produto produto);
	public void remove(Produto produto);
	public void update(Produto produto);
	public List<Produto> getAll();
}
