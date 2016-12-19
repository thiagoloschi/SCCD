package br.superdia.sessionbean;

import java.io.IOException;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.superdia.controller.RequestHTTP;

@Stateless
@Remote(IValidaCompra.class)
public class ValidaCompraBean implements IValidaCompra {
	
	private static final String REQUEST_CREDIT_CARD_VALIDATION = "http://www.webservicex.net/CreditCard.asmx/ValidateCardNumber?";
	private static final String CARD_TYPE_PARAM = "cardType=";
	
	private static final String CARD_NUMBER_PARAM = "&cardNumber=";
	
	private static final String RESPONSE_CREDIT_CARD_INVALID = "This Credit Card number is not valid.";
	
	@Override
	public boolean validaCartao(String tipoCartao, String numeroCartao) {
		RequestHTTP requestHTTP = new RequestHTTP();
		
		String urlGet = REQUEST_CREDIT_CARD_VALIDATION + CARD_TYPE_PARAM + tipoCartao + CARD_NUMBER_PARAM + numeroCartao;
		
		String response;
		
		try {
			response = requestHTTP.sendingGetRequest(urlGet);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
