package br.superdia.sessionbean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import br.superdia.jpa.JPAUtil;
import br.superdia.modelo.Usuario;

@Stateless
@Remote(IDAO.class)
public class DAOBean<T> implements IDAO<T> {

	private EntityManager em;	

	public void add(T t) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(T t) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		em.close();
	}

	public void update(T t) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}

	public List<T> getAll(Class<T> classe) {
		em = JPAUtil.getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}

	public T getForId(Long id, Class<T> classe) {
		em = JPAUtil.getEntityManager();
		T t = (T) em.find(classe, id);
		em.close();
		return t;
	}
	
	public String authenticate(Usuario usuario) {
		em = JPAUtil.getEntityManager();
		String q = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha";
		Usuario result;

		try{
			TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
			query.setParameter("usuario", usuario.getUsuario());
			query.setParameter("senha", usuario.getSenha());
			result = query.getSingleResult();
			result.setToken(result.generateToken());
			update(((T)result));
			em.close();
		}catch(Exception e){
			return null;
		}
		return result.getToken();
	}
	
}
