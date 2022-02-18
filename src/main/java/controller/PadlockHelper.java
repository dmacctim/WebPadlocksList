package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Padlock;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 2, 2022  
*/
public class PadlockHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PadlocksList");
	
	public void insertPadlock(Padlock pl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pl);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Padlock> showAllPadlocks() {
		EntityManager em = emfactory.createEntityManager();
		List<Padlock> allPadlocks = em.createQuery("SELECT i FROM Padlock i").getResultList();
		return allPadlocks;
	}
	
	public void deletePadlock(Padlock toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Padlock> typedQuery = em.createQuery("select pl from Padlock pl where pl.brand = :selectedBrand and pl.model = :selectedModel and pl.numPins = :selectedNumPins and pl.hasSecurityPins = :selectedHasSecurityPins", Padlock.class);
		
		typedQuery.setParameter("selectedBrand", toDelete.getBrand());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedNumPins", toDelete.getNumPins());
		typedQuery.setParameter("selectedHasSecurityPins", toDelete.isHasSecurityPins());
		typedQuery.setMaxResults(1);
		
		Padlock result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Padlock searchForPadlockById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Padlock found = em.find(Padlock.class, id);
		em.close();
		return found;
	}
	
	public List<Padlock> searchForPadlockByBrand(String brand) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Padlock> typedQuery = em.createQuery("select pl from Padlock pl where pl.brand = :selectedBrand", Padlock.class);
		typedQuery.setParameter("selectedBrand", brand);
		
		List<Padlock> foundPadlocks = typedQuery.getResultList();
		em.close();
		return foundPadlocks;
	}

	public List<Padlock> searchForPadlockByModel(String model) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Padlock> typedQuery = em.createQuery("select pl from Padlock pl where pl.model = :selectedModel", Padlock.class);
		typedQuery.setParameter("selectedModel", model);
		
		List<Padlock> foundPadlocks = typedQuery.getResultList();
		em.close();
		return foundPadlocks;
	}
	
	public void updatePadlock(Padlock toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
