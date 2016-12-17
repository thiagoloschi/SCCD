package br.superdia.sessionbean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.superdia.jpa.JPAUtil;

@Stateless
@Remote(IDAO.class)
public class IDAOBean<T> implements IDAO<T> {

	public void add(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		em.close();
	}

	public void update(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}

	public List<T> getAll(Class<T> classe) {
		EntityManager em = JPAUtil.getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}

	public T getForId(Long id, Class<T> classe) {
		EntityManager em = JPAUtil.getEntityManager();
		return (T) em.find(classe, id);
	}
}
