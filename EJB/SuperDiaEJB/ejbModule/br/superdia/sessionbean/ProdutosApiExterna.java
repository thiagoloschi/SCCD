package br.superdia.sessionbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.superdia.controller.RequestHTTP;
import br.superdia.modelo.Produto;

@Remote(IProdutosAPIExterna.class)
@Stateless
public class ProdutosApiExterna implements IProdutosAPIExterna {
	//https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6
	
	@Override
	public List<Produto> getAll(String url) {
		
		List<Produto> produtos = new ArrayList<>();
		
		try {
			//Obtém os dados da URL recebida.
			System.out.println("O que chegou: " + url);
			RequestHTTP requestHTTP = new RequestHTTP();
			String response = requestHTTP.sendingGetRequest(url);
			System.out.println("REsposta: " + response);
			//Obteve a resposta
			JSONObject object = new JSONObject(response);
			JSONArray ob = object.getJSONArray("products");
			
			for(int i = 0; i < ob.length(); i++){
				Produto p = new Produto();
				
				p.setVendidoPor(ob.getJSONObject(i).get("vendor").toString());
				p.setNome(ob.getJSONObject(i).get("title").toString());
				p.setDescricao(ob.getJSONObject(i).get("tags").toString());
				
				JSONArray td = (JSONArray) ob.getJSONObject(i).get("variants");
				for(int j = 0; j < td.length(); j++){
					try {
						p.setQuantidadeEstoque(convertToInteger(td.getJSONObject(j).get("inventory_quantity").toString()));
						p.setEstoqueMinimo(convertToInteger(td.getJSONObject(j).get("old_inventory_quantity").toString()));
						p.setPreco(convertToDouble(td.getJSONObject(i).get("price").toString()));
						produtos.add(p);
					} catch (JSONException e) {
						break;
					}	
				}
				
			}
			
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//getAll()
	
	private Double convertToDouble(String value){
		try {
			return Double.valueOf(value);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private int convertToInteger(String value){
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return -1;
	}
}//class ProdutosApi
