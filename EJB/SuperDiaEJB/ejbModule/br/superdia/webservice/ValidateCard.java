package br.superdia.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.superdia.sessionbean.ValidaCompraBean;

@WebService
@Stateless
public class ValidateCard {

	@EJB
	private ValidaCompraBean validaCompraBean;
	
	public Boolean validaCartao(String bandeiraCartao, String numeroCartao) {
		return validaCompraBean.validaCartao(bandeiraCartao, numeroCartao);
	}
	
}
