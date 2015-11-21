package model;

import javax.persistence.Id;

public class Lieu extends Ressource {
	@Id
	private int id;
	private String nom;
	
	public Lieu(String nom) {
		super(nom);
	}

}
