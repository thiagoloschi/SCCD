package br.superdia.sessionbean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.superdia.modelo.Produto;

@Stateless
@Remote(IProduto.class)
public class ProdutoBean implements IProduto {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("SuperDiaEJB");
	private EntityManager em;
	
	public void add(Produto produto) {
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(Produto produto) {
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(produto));
		em.getTransaction().commit();
		em.close();
	}

	public void update(Produto produto) {
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();
	}

	public List<Produto> getAll() {
		em = factory.createEntityManager();
		TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
		List<Produto> products = query.getResultList();
		em.close();
		return products;
	}
}
