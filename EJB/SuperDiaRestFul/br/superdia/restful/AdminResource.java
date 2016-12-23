package br.superdia.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.json.JSONObject;

import br.superdia.message.RespostasJSON;
import br.superdia.modelo.Perfil;
import br.superdia.modelo.Produto;
import br.superdia.modelo.Usuario;
import br.superdia.sessionbean.IDAO;
import br.superdia.sessionbean.IProdutosAPIExterna;
import br.superdia.sessionbean.IUsuarioDAO;
import br.superdia.sessionbean.IValidaCompra;

@Path("parceiros")
public class AdminResource {
	
	@EJB
	private IDAO<Produto> idao;
	
	@EJB
	private IUsuarioDAO iUsuarioDAO;
	
	@EJB
	private IProdutosAPIExterna iProdutosAPIExterna;
	@EJB
	private IValidaCompra iValidaCompra;
	
	@Path("cadastrar_produtos")
	@POST
	@Consumes("application/json")
	public String getProductsWeb(final @QueryParam("token") String token, String api){
		//Obtém a url enviada pelo json.
		JSONObject obj = new JSONObject(api);
		String apiUrl = obj.getString("api");
		
		//Valida o token do usuário.
		if (iValidaCompra.tokenIsValid(token)) {
			//Obtém o usuário e verifica se o perfil do mesmo é de ADMINISTRADOR.
			Usuario user = iUsuarioDAO.getByToken(token);
			
			if (user.getPerfil().equalsIgnoreCase(Perfil.ADMINISTRADOR.getPerfil())) {
				List<Produto> produtos = iProdutosAPIExterna.getAll(apiUrl);	
				produtos.forEach(p -> { idao.add(p); });
				
				return RespostasJSON.SUCESSO_IMPORTAR_PRODUTOS.getMensagem();
			}
		}
		return RespostasJSON.ERRO_IMPORTAR_PRODUTOS.getMensagem();
	}
}
