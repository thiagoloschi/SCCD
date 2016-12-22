package br.superdia.message;

public enum RespostasJSON {
	
	//JSON Usuário
	ERRO_USUARIO_INVALIDO("{'cod' : 401, 'msg':'Usuário não encontrado.'}"),
	
	//JSON Carrinho
	CARRINHO_VAZIO("{'cod': '204', 'msg': 'Carrinho vazio.'}"),
	ITEM_ARMAZENADO("{'cod': '204', 'msg': 'Item inserido com sucesso.'}"),
	ITEM_EXCLUIDO("{'cod': '204', 'msg': 'Item removido com sucesso.'}"),
	
	//Cartão Usuário.
	ERRO_CARTAO("{'cod': '666', 'msg': 'Cartão inválido.'}"),
	
	SUCESSO("{'cod': '200', 'msg': 'Realizada com sucesso.'}");

	//Mensagem Compra
	SUCESSO_COMPRA("{'cod': '200', 'msg': 'Compra realizada com sucesso.'}");

	private RespostasJSON(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
}
