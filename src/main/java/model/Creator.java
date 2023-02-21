package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creator")
public class Creator {
	/*
	 * This class will create a one to many relationship with the Character class
	 * Since every Creator can have many Characters
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
		return "User [id=" + id + ", name=" + name + "]";
	}
}
