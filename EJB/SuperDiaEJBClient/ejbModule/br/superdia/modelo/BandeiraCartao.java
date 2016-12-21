package br.superdia.modelo;

//Define os tipos de cartão de crédito que podem ser validados pela api "http://www.webservicex.net/New/Home/ServiceDetail/14".
public enum BandeiraCartao {
	VISA("VISA"),
	MASTERCARD("MATERCARD"),
	DINERS("DINERS"),
	AMEX("AMEX");
	
	private BandeiraCartao(String bandeira) {
		this.bandeira = bandeira;
	}

	public String bandeira;
}
