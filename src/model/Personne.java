package model;

import java.util.Date;

public class Personne extends Ressource {
	private Date naissance;

	public Personne(String nom, Date naissance) {
		super(nom);
		this.naissance = naissance;
	}
	
}
