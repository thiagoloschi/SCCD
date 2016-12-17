package br.superdia.modelo;

public enum Mensagem {
	
	CAMPO_NOME("O nome deve ser informado e não deve exceder 40 caracteres."),
	CAMPO_DESCRICAO("A descrição deve ser informada."),
	CAMPO_ESTOQUE("A quantidade em estoque mínima deve ser informada."),
	CAMPO_QUANTIDADE_ESTOQUE("A quantidade em estoque atual deve ser informada.");
	
	private final String mensagem;
	
	Mensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	String getMensagem() {
		return mensagem;
	}
}
