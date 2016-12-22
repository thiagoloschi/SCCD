package br.superdia.managebean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.superdia.modelo.ItemVenda;
import br.superdia.modelo.Produto;
import br.superdia.sessionbean.ICarrinho;

@ManagedBean
@SessionScoped
public class CarrinhoMB {

	@EJB
	private ICarrinho icarrinho;
	private List<ItemVenda>produtos;

	public float total = 0;
	
	public void addProdutoCarrinho(Produto produto, Integer quantidade){
		
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(quantidade.longValue());
		
		icarrinho.addProduct(itemVenda);
		atualizaLista();
		getTotal();

	}

	public void removerProdutoCarrinho(Produto produto, Integer quantidade){
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(quantidade.longValue());
		
		icarrinho.removeProduct(itemVenda);
		atualizaLista();
		getTotal();

	}

	public List<ItemVenda>getProdutos(){

		if(produtos==null)
			this.produtos = icarrinho.getItemVendas(); //icarrinho.getItens();
		return produtos;

	}

	private void atualizaLista(){

		this.produtos = icarrinho.getItemVendas();

	}

	public float getTotal() {
		
		if(produtos == null)
			return 0;
		
		total = 0;

		for(int contador = 0; contador < produtos.size(); contador++)
			total += produtos.get(contador).getProduto().getPreco();

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
