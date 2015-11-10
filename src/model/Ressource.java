package model;

public class Ressource {
	private String nom;
	
	public Ressource(String nom){
		this.nom = nom;
		this.charger();
	}
	
	public Ressource charger(){
		//TODO implement depending on database
		return this;
	}
	
	public Ressource sauver(){
		//TODO implement depending on database
		return this;
	}
	
	public boolean supprimer(){
		//TODO implement depending on database
		return true;
	}

	public String getNom() {
		return nom;
	}

}
