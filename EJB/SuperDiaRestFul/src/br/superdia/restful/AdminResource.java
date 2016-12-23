package br.superdia.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.json.JSONObject;

import br.superdia.message.RespostasJSON;
import br.superdia.modelo.Produto;
import br.superdia.sessionbean.IDAO;
import br.superdia.sessionbean.IProdutosAPIExterna;

@Path("admin")
public class AdminResource {
	
	@EJB
	private IDAO<Produto> idao;
	@EJB
	private IProdutosAPIExterna iProdutosAPIExterna;
	
	@Path("cadastrar_produtos_externos")
	@POST
	@Consumes("application/json")
	public String getProductsWeb(final @QueryParam("token") String token, String api){
		//Apenas teste de importação dos dados.
		
		//produtos.forEach( p -> { idao.add(p); });
		JSONObject obj = new JSONObject(api);
		String apiUrl = obj.getString("api");
		List<Produto> produtos = iProdutosAPIExterna.getAll(apiUrl);
		
		produtos.forEach(p -> { idao.add(p); });
		return RespostasJSON.SUCESSO_IMPORTAR_PRODUTOS.getMensagem();
	}
}
