package model;

import java.util.List;

import javax.persistence.Id;

public class Groupe extends Ressource {
	@Id
	private int id;
	private String nom;
	private List<Personne> membres;
	
	public Groupe(String nom) {
		super(nom);
		this.charger(); //TODO load()
	}
	
	@Override
	public Ressource charger(){
		//TODO implement depending on db
		return this;
	}
	
	@Override
	public Ressource sauver() {
		//TODO implement depending on db
		return this;
	}
}

