package br.superdia.app;

/*
 * Define os perfis de acesso que poderão ser criados na aplicação.
 */
public enum Perfil {
	ADMINISTRADOR("ADMINISTRADOR"),
	CAIXA("CAIXA"),
	CLIENTE("CLIENTE");
	
	private String perfil;

	private Perfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}
}
