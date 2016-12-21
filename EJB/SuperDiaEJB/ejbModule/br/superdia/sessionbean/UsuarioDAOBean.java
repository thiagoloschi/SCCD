package br.superdia.sessionbean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.superdia.jpa.JPAUtil;
import br.superdia.modelo.Usuario;

@Stateless
@Remote(IUsuarioDAO.class)
public class UsuarioDAOBean implements IUsuarioDAO {
	
	/*
	 * Verifica se um usuário é válido, caso seja, retorna o perfil do mesmo para
	 * que possa ser setado no objeto e liberar apenas suas permissões de acesso.
	 */
	public boolean isValid(Usuario usuario){
		EntityManager em = JPAUtil.getEntityManager();
		String q = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha";
		TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
		query.setParameter("usuario", usuario.getUsuario());
		query.setParameter("senha", usuario.getSenha());
		boolean result = !query.getResultList().isEmpty();
		em.close();
		return result;
	}
	
	/*
	 * Verifica se o usuário existe, caso exista ele retorna o Objeto usuário
	 * caso contrario retorna null.
	 */
	public Usuario getUser(Usuario usuario){
		EntityManager em = JPAUtil.getEntityManager();
		String q = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha";
		Usuario result;
		try{
			TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
			query.setParameter("usuario", usuario.getUsuario());
			query.setParameter("senha", usuario.getSenha());
			result = query.getSingleResult();
			em.close();
		}catch(Exception e){
			return null;
		}
		return result;
	}
	
}
