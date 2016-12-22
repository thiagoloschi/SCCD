package br.superdia.sessionbean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.validator.routines.CreditCardValidator;

import br.superdia.jpa.JPAUtil;
import br.superdia.modelo.Usuario;

@Stateless
@Remote(IValidaCompra.class)
public class ValidaCompraBean implements IValidaCompra {

	
	/*
	 * Realiza a validação do cartão de crédito informado pelo usuário para efetivação da compra.
	 * Recebe como parâmetros uma String referente a bandeira do cartão, onde os valores possíveis
	 * estão definidos no enum BandeiraCartao. O segundo é uma String referênte ao número do cartão.
	 * Retorna true em caso de cartão válido e false em caso contrário. 
	 */
	public boolean validaCartao(String bandeiraCartao, String numeroCartao) {
		CreditCardValidator creditCardValidator = new CreditCardValidator();
		return creditCardValidator.isValid(numeroCartao);
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
