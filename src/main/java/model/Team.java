package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate dateCreated;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Creator creator;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Character> charactersList;
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int id, String listName, LocalDate dateCreated, Creator creator,
			List<Character> charactersList) {
		super();
		this.id = id;
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.creator = creator;
		this.charactersList = charactersList;
	}

	public Team(String listName, LocalDate dateCreated, Creator creator, List<Character> charactersList) {
		super();
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.creator = creator;
		this.charactersList = charactersList;
	}

	public Team(String listName, LocalDate dateCreated, Creator creator) {
		super();
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "CharacterList [id=" + id + ", listName=" + listName + ", dateCreated=" + dateCreated + ", creator="
				+ creator + ", charactersList=" + charactersList + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public List<Character> getCharactersList() {
		return charactersList;
	}

	public void setCharactersList(List<Character> charactersList) {
		this.charactersList = charactersList;
	}
	
}
