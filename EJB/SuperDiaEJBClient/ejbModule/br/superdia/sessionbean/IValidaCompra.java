package br.superdia.sessionbean;

//Declara os métodos que serão utilizados para validação da compra do usuário.
public interface IValidaCompra {
	public boolean validaCartao(String bandeiraCartao, String numero);
}
