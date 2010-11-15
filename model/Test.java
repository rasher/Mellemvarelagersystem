/**
 * 
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Jonas Häggqvist (10dm10v1)
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Produkttype p = new Produkttype();
		p.setNavn("Skumbananer");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Mellemvarelager");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
