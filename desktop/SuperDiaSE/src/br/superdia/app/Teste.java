package br.superdia.app;

import br.superdia.webservice.ValidateCard;
import br.superdia.webservice.ValidateCardService;

public class Teste {

	public static void main(String[] args) {
		ValidateCardService service = new ValidateCardService();
		ValidateCard userClient = service.getValidateCardPort();
		
		if(userClient.validaCartao("73", "4352345"))
			System.out.println("Funcionou...");
		else
			System.out.println("Não Funciona...");
	}

}
