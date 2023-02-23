package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class TeamHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7PartnerProject");
	
	public void addNewTeam(Team c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteTeam(Team delete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("SELECT cl FROM CharacterList cl WHERE cl.id = :selectedId", Team.class);
		typedQuery.setParameter("selectedId", delete.getId());
		typedQuery.setMaxResults(1);
		Team result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void editTeam(Team edit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(edit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Team> getTeams(){
		EntityManager em = emfactory.createEntityManager();
		List<Team> allCharacterLists = em.createQuery("SELECT c FROM CharacterList c").getResultList();
		return allCharacterLists;
	}
	
	public Team searchTeamByID(Integer id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team found = em.find(Team.class, id);
		em.close();
		return found;
	}
	
}
