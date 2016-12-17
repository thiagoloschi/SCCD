package br.superdia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SuperDiaEJB");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
