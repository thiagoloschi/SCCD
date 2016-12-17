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

	public float total = 0;
	
	public void addProdutoCarrinho(Produto produto){

		icarrinho.addProduct(produto);
		atualizaLista();
		getTotal();

	}

	public void removerProdutoCarrinho(Produto produto){

		icarrinho.removeProduct(produto);
		atualizaLista();
		getTotal();

	}

	public List<Produto>getProdutos(){

		if(produtos==null)
			this.produtos = icarrinho.getItens();
		return produtos;

	}

	private void atualizaLista(){

		this.produtos = icarrinho.getItens();

	}

	public float getTotal() {
		
		if(produtos == null)
			return 0;
		
		total = 0;

		for(int contador = 0; contador < produtos.size(); contador++)
			total += produtos.get(contador).getPreco();

		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void clearCarrinho(){
		
		icarrinho.clearItens();
		atualizaLista();
		
	}

}
