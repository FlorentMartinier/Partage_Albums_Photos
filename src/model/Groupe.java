package model;

import java.util.List;

public class Groupe extends Ressource {
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

