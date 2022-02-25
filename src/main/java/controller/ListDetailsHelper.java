package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 23, 2022  
*/
public class ListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PadlocksList");
	
	public void insertNewListDetails(ListDetails ld) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ld);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(ListDetails listToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createQuery("select detail from ListDetails detail where detail.id = :selectedId", ListDetails.class);
		typedQuery.setParameter("selectedId", listToDelete.getId());
		typedQuery.setMaxResults(1);
		ListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(ListDetails listToUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(listToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
