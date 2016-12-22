package br.superdia.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.superdia.modelo.ShopifyProduct;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RequestHTTP requestHTTP = new RequestHTTP();
			String response = requestHTTP.sendingGetRequest("https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6");
			
			//System.out.println(response);
			
			JSONObject jsonObject = new JSONObject(response);
			
			Gson gson = new Gson();

			
//			System.out.println(teste);
			JSONArray array = jsonObject.getJSONArray("products");
			
			
			
			//List<Produto> produtosJSON = Arrays.asList(gson.fromJson(response, Produto[].class));
			//produtos.addAll(produtosJSON);
			
			List<ShopifyProduct> products = Arrays.asList(gson.fromJson(array.toString(), ShopifyProduct[].class));
			System.out.println(products.size());
			products.forEach( p -> { System.out.println(p.getTitle()); });

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
