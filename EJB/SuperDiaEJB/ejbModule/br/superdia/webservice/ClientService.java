package br.superdia.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.superdia.modelo.Produto;
import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.ICarrinho;
import br.superdia.sessionbean.IDAO;

@Stateless
@WebService
public class ClientService {
	
	@EJB
	private IDAO<Produto> produtosDao;
	
	@EJB
	private ICarrinho carrinho;
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = produtosDao.getAll(Produto.class);
		return produtos;
	}
	
	public List<Produto> getCarrinho(){
		return carrinho.getItens();
	}
	
	public Boolean addProdutoCarrinho(Long id){
		try {
			Produto produto = produtosDao.getForId(id, Produto.class);
			carrinho.addProduct(produto);
		} catch (Exception e) {
			return false;
		}
			return true;
	}

	public Boolean removeProdutoCarrinho(Long id){
		try {
			Produto produto = produtosDao.getForId(id, Produto.class);
			carrinho.removeProduct(produto);
		} catch (Exception e) {
			return false;
		}
			return true;
	}
	
	public Boolean cleanCarrinho(){
		try {
			carrinho.clearItens();
		} catch (Exception e) {
			return false;
		}
			return true;
	}

	/**
	 * Você deve fornecer o usuario para finalizar a compra.
	 * @param usuario
	 * @return true caso compra finalizado com sucesso
	 * ou false com houver erro.
	 */
	public Boolean endsBuy(Usuario usuario){
		try {
			carrinho.endsBuy(usuario);
		} catch (Exception e) {
			return false;
		}
			return true;
	}
	
}