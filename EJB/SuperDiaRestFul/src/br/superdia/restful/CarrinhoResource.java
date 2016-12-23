package br.superdia.restful;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import br.superdia.message.RespostasJSON;
import br.superdia.modelo.DadosCompra;
import br.superdia.modelo.ItemVenda;
import br.superdia.modelo.Usuario;
import br.superdia.modelo.Venda;
import br.superdia.sessionbean.ICarrinho;
import br.superdia.sessionbean.IDAO;
import br.superdia.sessionbean.IUsuarioDAO;
import br.superdia.sessionbean.IValidaCompra;

/*
 * Implementa as funcionalidades do carrinho de compras na API RestFul.
 */
@Path("carrinho")
public class CarrinhoResource {
	private Gson gson = new Gson();
	private List<ItemVenda> itens = new ArrayList<>();
	
	@EJB
	private IValidaCompra validarCompra;
	@EJB
	private ICarrinho carrinho;
	@EJB
	private IUsuarioDAO dao;
	@EJB
	private IDAO<Venda> daoVenda;
	
	/*
	 * Adiciona um item ao carrinho, caso o usuário seja válido. Entende-se na nossa lógica de negócios, um usuário válido,
	 * como aquele que possui um token de acesso as operações da API. Isso garante que seja um usuário válido e portanto,
	 * previamente cadastrado.
	 */
	@Path("inserir")
	@POST
	@Consumes("application/json")
	public String addItem(String item, final @QueryParam("token") String token){
		if(validarCompra.tokenIsValid(token)) {
			ItemVenda itemVenda = gson.fromJson(item, ItemVenda.class);
			itens.add(itemVenda);
			return RespostasJSON.ITEM_ARMAZENADO.getMensagem();
		}
		return RespostasJSON.ERRO_USUARIO_INVALIDO.getMensagem();
	}
	
	@Path("remover/{id}")
	@DELETE
	@Consumes("application/json")
	public String removeItem(final @QueryParam("id") String id, final @QueryParam("token") String token){
		if(validarCompra.tokenIsValid(token)){
			itens.removeIf(i -> i.getId() == Long.valueOf(id));
			return RespostasJSON.ITEM_EXCLUIDO.getMensagem();
		}
		return RespostasJSON.ERRO_USUARIO_INVALIDO.getMensagem();
	}
	
	@Path("listar")
	@GET
	@Produces("application/json")
	public String getAll(final @QueryParam("token") String token){
		return validarCompra.tokenIsValid(token) ? gson.toJson(itens.toString()) : RespostasJSON.ERRO_USUARIO_INVALIDO.getMensagem();
	}
	
	@Path("limpar")
	@GET
	public void clearItens(final @QueryParam("token") String token){
		if (validarCompra.tokenIsValid(token)) itens.clear();
	}
	
	@Path("finalizar")
	@POST
	@Consumes("application/json")
	public String buy(final @QueryParam("token") String token, String info){
		DadosCompra dados = gson.fromJson(info, DadosCompra.class);
		
		//Verifica se o token do usuário é válido através do seu token.
		if (validarCompra.tokenIsValid(token)){
			//Caso sejá, verifica se o cartão informado pelo usuário é válido.
			//if(validarCompra.validaCartao(dados.getTipo(), dados.getNumero())){
			
			if(validarCompra.validaCartao(dados.getTipo(), dados.getNumero())){	
				//Obtêm os dados do usuário e seta os itens no carrinho.
				Usuario u = dao.getByToken(token);
				itens.clear();
				dados.getItensVenda().forEach( d -> { itens.add(d); });
				
				//Seta os dados da venda.
				Venda venda = new Venda();
				venda.setData(Calendar.getInstance());
				venda.setProdutos(itens);
				venda.setUsuario(u);
				
				//Salva no banco e limpa os itens do carrinho.
				daoVenda.add(venda);
				itens.clear();
				return RespostasJSON.SUCESSO_COMPRA.getMensagem();
			}
			return RespostasJSON.ERRO_CARTAO.getMensagem();
		}
		//Caso o token não seja válido.
		return RespostasJSON.ERRO_USUARIO_INVALIDO.getMensagem();
	}//buy()
}//class CarrinhoResource