package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creator")
public class Creator {
	/*
	 * This class will create a relationship with the CharacterListDetails class
	 * one creator can create many Character Lists
	 */
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public Creator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Creator(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Creator(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Creator [id=" + id + ", name=" + name + "]";
	}
}
