package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Lockpicker;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 23, 2022  
*/
public class LockpickerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PadlocksList");
	
	public void insertLockpicker(Lockpicker l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Lockpicker> showAllLockpickers() {
		EntityManager em = emfactory.createEntityManager();
		List<Lockpicker> allLockpickers = em.createQuery("SELECT l FROM Lockpicker l").getResultList();
		return allLockpickers;
	}

	public Lockpicker findLockpicker(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Lockpicker> typedQuery = em.createQuery("select lp from Lockpicker lp where lp.lockpickerName = :selectedName", Lockpicker.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Lockpicker foundLockpicker;
		try {
			foundLockpicker = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundLockpicker = new Lockpicker(nameToLookUp);
		}
		
		em.close();
		return foundLockpicker;
	}
}
