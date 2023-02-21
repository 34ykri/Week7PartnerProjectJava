package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CharacterList;

public class CharacterListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7PartnerProject");
	
	public void addNewCharacterList(CharacterList c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteCharacterList(CharacterList delete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharacterList> typedQuery = em.createQuery("SELECT cl FROM CharacterList cl WHERE cl.id = :selectedId", CharacterList.class);
		typedQuery.setParameter("selectedId", delete.getId());
		typedQuery.setMaxResults(1);
		CharacterList result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void editList(CharacterList edit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(edit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CharacterList> getCharacterLists(){
		EntityManager em = emfactory.createEntityManager();
		List<CharacterList> allCharacterLists = em.createQuery("SELECT c FROM CharacterList c").getResultList();
		return allCharacterLists;
	}
	
	public CharacterList searchForCharacterListByID(Integer id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CharacterList found = em.find(CharacterList.class, id);
		em.close();
		return found;
	}
	
}
