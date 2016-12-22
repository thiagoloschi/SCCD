package br.superdia.sessionbean;

import br.superdia.modelo.Usuario;

public interface IUsuarioDAO {
	public boolean isValid(Usuario usuario);
	public Usuario getUser(Usuario usuario);
	public Usuario getByToken(String token);
}
