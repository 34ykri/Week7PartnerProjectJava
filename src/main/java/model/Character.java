package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="characters")
public class Character {
	/*
	 * This class holds information known as Characters which a Creator can
	 * create
	 */
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String characterName;
	@Column(name="CLASS")
	private String characterClass;
	@Column(name="RACE")
	private String characterRace;
	@Column(name="LEVEL")
	private int characterLevel;
	
	public Character() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Character(String characterName, String characterClass, String characterRace, int characterLevel) {
		super();
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.characterLevel = characterLevel;
	}
	
	//USED FOR EDITING/Deleting CHARACTER, otherwise use constructor above
	public Character(String name, String chClass) {
		// TODO Auto-generated constructor stub
		super();
		this.characterName = name;
		this.characterClass = chClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public String getCharacterRace() {
		return characterRace;
	}

	public void setCharacterRace(String characterRace) {
		this.characterRace = characterRace;
	}

	public int getCharacterLevel() {
		return characterLevel;
	}

	public void setCharacterLevel(int characterLevel) {
		this.characterLevel = characterLevel;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", characterName=" + characterName + ", characterClass=" + characterClass
				+ ", characterRace=" + characterRace + ", characterLevel=" + characterLevel + "]";
	}
	
	
}
