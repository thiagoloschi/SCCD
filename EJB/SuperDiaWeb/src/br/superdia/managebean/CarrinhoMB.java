package br.superdia.managebean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.validator.routines.CreditCardValidator;

import br.superdia.modelo.ItemVenda;
import br.superdia.modelo.Produto;
import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.ICarrinho;
import br.superdia.utils.SessionUtil;

@ManagedBean
@SessionScoped
public class CarrinhoMB {

	@EJB
	private ICarrinho icarrinho;
	
	private List<ItemVenda>produtos;

	private String numeroCartao;

	public float total = 0;

	public void addProdutoCarrinho(Produto produto, Integer quantidade){

		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(quantidade.longValue());

		icarrinho.addProduct(itemVenda);
		atualizaLista();
		getTotal();

	}

	public void removerProdutoCarrinho(ItemVenda item, Integer quantidade){

		icarrinho.removeProduct(item);
		System.out.println(icarrinho.getItemVendas().toString());
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

	public void endsBuy(){

		CreditCardValidator creditCardValidator = new CreditCardValidator();
		if(creditCardValidator.isValid(numeroCartao) && produtos.size() != 0){

			Usuario usuario = (Usuario) SessionUtil.getSession().getAttribute("USUARIOLogado");
			System.out.println("\n\n********* user " + usuario.getUsuario());
			icarrinho.endsBuy(usuario);
			atualizaLista();
		}

	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

}
