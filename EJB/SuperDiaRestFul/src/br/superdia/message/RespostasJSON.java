package br.superdia.message;

public enum RespostasJSON {
	
	ERRO_USUARIO_INVALIDO("{'erro':'Usuário não encontrado.'}");
	
	private RespostasJSON(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
}
