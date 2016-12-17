package br.superdia.managebean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.superdia.modelo.Produto;
import br.superdia.sessionbean.ICarrinho;

@ManagedBean
@SessionScoped
public class CarrinhoMB {

	@EJB
	private ICarrinho icarrinho;
	private List<Produto>produtos;
	
	public void addProdutoCarrinho(Produto produto){
		
		icarrinho.addProduct(produto);
		atualizaLista();
		
	}
	
	public void removerProdutoCarrinho(Produto produto){
		
		icarrinho.removeProduct(produto);
		atualizaLista();
		
	}
	
	public List<Produto>getProdutos(){
		
		if(produtos==null)
			this.produtos = icarrinho.getItens();
		return produtos;
		
	}
	
	private void atualizaLista(){
		
		this.produtos = icarrinho.getItens();
		
	}
	
}
