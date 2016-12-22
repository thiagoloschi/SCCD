package br.superdia.sessionbean;

import java.io.IOException;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.superdia.controller.RequestHTTP;
import br.superdia.jpa.JPAUtil;
import br.superdia.modelo.Usuario;

@Stateless
@Remote(IValidaCompra.class)
public class ValidaCompraBean implements IValidaCompra {
	
	private static final String REQUEST_CREDIT_CARD_VALIDATION = "http://www.webservicex.net/CreditCard.asmx/ValidateCardNumber?";
	private static final String CARD_TYPE_PARAM = "cardType=";	
	private static final String CARD_NUMBER_PARAM = "&cardNumber=";
	private static final String RESPONSE_CREDIT_CARD_INVALID = "This Credit Card number is not valid.";
	
	/*
	 * Realiza a validação do cartão de crédito informado pelo usuário para efetivação da compra.
	 * Recebe como parâmetros uma String referente a bandeira do cartão, onde os valores possíveis
	 * estão definidos no enum BandeiraCartao. O segundo é uma String referênte ao número do cartão.
	 * Retorna true em caso de cartão válido e false em caso contrário. 
	 */
	public boolean validaCartao(String bandeiraCartao, String numeroCartao) {
		RequestHTTP requestHTTP = new RequestHTTP();
		String urlGet = REQUEST_CREDIT_CARD_VALIDATION + CARD_TYPE_PARAM + bandeiraCartao + CARD_NUMBER_PARAM + numeroCartao;	
		String response;
		
		try {
			response = requestHTTP.sendingGetRequest(urlGet);
			return  response.contains(RESPONSE_CREDIT_CARD_INVALID) ? false : true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean tokenIsValid(String token) {
		EntityManager em = JPAUtil.getEntityManager();
		String q = "SELECT u FROM Usuario u WHERE u.token = :token";
		Usuario result;
		try{
			TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
			query.setParameter("token", token);
			result = query.getSingleResult();
			em.close();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}//validaCartao()
