package br.superdia.managebean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.superdia.modelo.Produto;
import br.superdia.sessionbean.IDAO;

/**
 * Classe responsavel pelo gerenciamento de estoque. 
 */
@ManagedBean
@SessionScoped
public class ProdutoMB {
	@EJB
	private IDAO<Produto> iProduto;
	
	//Lista de produtos
	private List<Produto> produtos;
	
	private Produto produto = new Produto();
	
	public void aumentarQtdEstoque(Produto produto){
		produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + 1);
	}
	
	public void diminuirQtdEstoque(Produto produto){
		produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);
	}
	
	public void gravaProduto(){		
		if(produto.getId() == null)
			iProduto.add(produto);
		else iProduto.update(produto);
		
		produto = new Produto();
		produtos = iProduto.getAll(Produto.class);
	}
	
	public void remove(Produto produto){
		iProduto.remove(produto);
		produtos = iProduto.getAll(Produto.class);
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		if(produtos==null)
			this.produtos = iProduto.getAll(Produto.class);
		return produtos;

	}
	
}// class
