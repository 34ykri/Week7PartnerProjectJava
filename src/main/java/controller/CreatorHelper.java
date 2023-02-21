package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Creator;

public class CreatorHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7PartnerProject");
	
	public void addCreator(Creator c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public Creator findCreator(String creatorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Creator> typedQuery = em.createQuery("SELECT c FROM Creator c WHERE c.name = :selectedName", Creator.class);
		typedQuery.setParameter("selectedName", creatorName);
		typedQuery.setMaxResults(1);
		Creator found;
		try {
			found = typedQuery.getSingleResult();
		}
		catch(NoResultException ex) {
			found = new Creator(creatorName);
		}
		em.close();
		return found;
	}
	
	public List<Creator> showAllCreators(){
		EntityManager em = emfactory.createEntityManager();
		List<Creator> allCreators = em.createQuery("SELECT c FROM Creator c").getResultList();
		return allCreators;
	}
}
