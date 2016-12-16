package br.superdia.sessionbean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.superdia.modelo.Usuario;

@Stateless
@Remote(IUsuario.class)
public class UsuarioBean implements IUsuario {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("SuperDiaEJB");
	private EntityManager em;
	
	public void add(Usuario usuario) {
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Usuario usuario) {
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(usuario));
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Usuario usuario) {
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Usuario> getAll(){
		em = factory.createEntityManager();
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		em.close();
		return usuarios;
	}
	
	public String isValid(Usuario usuario){
		em = factory.createEntityManager();
		String q = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha";
		TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
		query.setParameter("usuario", usuario.getUsuario());
		query.setParameter("senha", usuario.getSenha());
		Usuario u = query.getSingleResult();
		em.close();
		return u != null ? u.getPerfil() : null;
	}
}
