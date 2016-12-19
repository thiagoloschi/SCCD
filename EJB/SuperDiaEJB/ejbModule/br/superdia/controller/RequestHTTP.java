package br.superdia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Realiza as requisições
 */
public class RequestHTTP {
	private final static String USER_AGENT = "Mozilla/5.0";
	
	
	public String sendingGetRequest(String url) throws IOException {
		URL urlRequisition = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) urlRequisition.openConnection();
		
		//By default it is GET request
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		String response = readContent(con.getInputStream());
		
		return response;
	}//sendingGetRequest()
	
	//Realiza a leitura das informações recebidas.
	private String readContent(InputStream con) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con));
		
		String output;
		StringBuffer response = new StringBuffer();
		
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();
		
		return response.toString();
	}//readContent()
}//class RequestHTTP
