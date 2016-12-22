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
import br.superdia.modelo.Variants;

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
		
		for(int i = 0; i < products.size(); i++){
			Produto produto = new Produto();
			produto.setNome(products.get(i).getTitle());
			produto.setDescricao(products.get(i).getTags());
			produto.setVendidoPor(products.get(i).getVendor());
			System.out.println(products.get(i).getVendor());
			for(Variants v : products.get(i).getVariants()){
				System.out.println(v.getInventory_quantify());
			}
			
		};
		return produtos;
	}//parseProducts()
	
	public static void main(String[] args) {
		ProdutosApi api = new ProdutosApi();
		List<Produto> produtos = api.getAll("https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6");
		
		//produtos.forEach(p -> { System.out.println(p.getPreco()); });
	}
}//class ProdutosApi
