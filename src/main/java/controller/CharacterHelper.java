package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Character;

public class CharacterHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7PartnerProject");
	
	public void addCharacter(Character add) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(add);
		em.getTransaction().commit();
		em.close();
	}
	public void deleteCharacter(Character delete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Character> typedQuery = em.createQuery("SELECT ch FROM Character ch WHERE ch.characterName = :findName and ch.characterClass = :findClass", Character.class);
		typedQuery.setParameter("findName", delete.getCharacterName());
		typedQuery.setParameter("findClass", delete.getCharacterClass());
		typedQuery.setMaxResults(1);
		Character result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}
	//Find character by name and class
	public Character findCharacter(Character find) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Character> typedQuery = em.createQuery("SELECT ch FROM Character ch WHERE ch.characterName = :findName and ch.characterClass = :findClass", Character.class);
		typedQuery.setParameter("findName", find.getCharacterName());
		typedQuery.setParameter("findClass", find.getCharacterClass());
		typedQuery.setMaxResults(1);
		Character found;
		List<Character> characterList = typedQuery.getResultList();
		if(characterList.size() == 0) {
			found = null;
		}
		else {
			found = typedQuery.getSingleResult();
		}
		em.getTransaction().commit();
		em.close();
		return found;
	}
	//Find character by id
	public Character findCharacterID(int find) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Character found = em.find(Character.class, find);
		em.getTransaction().commit();
		em.close();
		return found;
	}
	
	public void editCharacter(Character edit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(edit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Character> showAllCharacters(){
		EntityManager em = emfactory.createEntityManager();
		List<Character> allCharacters = em.createQuery("SELECT i FROM Character i").getResultList();
		return allCharacters;
	}
	
}
