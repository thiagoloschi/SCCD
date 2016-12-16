package br.superdia.sessionbean;

import java.util.List;

import br.superdia.modelo.Usuario;

public interface IUsuario {
	public void add(Usuario usuario);
	public void remove(Usuario usuario);
	public void update(Usuario usuario);
	public List<Usuario> getAll();
	public String isValid(Usuario usuario);
}
