package br.superdia.sessionbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import br.superdia.controller.RequestHTTP;
import br.superdia.modelo.Produto;
import br.superdia.modelo.ShopifyProduct;

@Remote(IProdutosAPI.class)
@Stateless
public class ProdutosApi implements IProdutosAPI {
	//https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6
	
	@Override
	public List<Produto> getAll(String url) {
		
		List<ShopifyProduct> shopifyProducts;
		
		try {
			//Obtém os dados da URL recebida.
			RequestHTTP requestHTTP = new RequestHTTP();
			String response = requestHTTP.sendingGetRequest(url);
			
			JSONObject jsonObject = new JSONObject(response);
			Gson gson = new Gson();
			
			JSONArray jsonArray = jsonObject.getJSONArray("products");
			shopifyProducts = Arrays.asList(gson.fromJson(jsonArray.toString(), ShopifyProduct[].class));
			
			return parseProducts(shopifyProducts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//getAll()
	
	private List<Produto> parseProducts(List<ShopifyProduct> products){
		
		List<Produto> produtos = new ArrayList<>();
		
		products.forEach( p -> {  
			Produto produto = new Produto();
			produto.setNome(p.getTitle());
			produto.setDescricao(p.getTags());
			produto.setVendidoPor(p.getVendor());
			
			p.getVariants().forEach( p2 -> {
				produto.setQuantidadeEstoque(Integer.valueOf(p2.getOld_inventory_quantify()));
				produto.setEstoqueMinimo(Integer.valueOf(p2.getOld_inventory_quantify()));
				produto.setPreco(Double.valueOf(p2.getPrice()));
				
				produtos.add(produto);
			});
		});
		return produtos;
	}//parseProducts()
}//class ProdutosApi
