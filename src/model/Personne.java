package model;

import java.util.Date;

import javax.persistence.Id;

public class Personne extends Ressource{
	@Id
	private int id;
	private Date naissance;

	public Personne(String nom, Date naissance) {
		super(nom);
		this.naissance = naissance;
	}
}
