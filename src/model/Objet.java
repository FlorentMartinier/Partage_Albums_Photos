package model;

import javax.persistence.Id;

public class Objet extends Ressource{
	@Id
	private int id;
	
	public Objet(String nom) {
		super(nom);
	}
	
}
