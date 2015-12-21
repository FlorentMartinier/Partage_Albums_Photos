package model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

public class Photo {
	private AppUser createur;
	private String nom;
	private Date date;
	private String description;
	private String lieu;
	@Id
	private Path p;
	
	public Photo(Path p, AppUser createur, String nom, Date date, String description, String lieu){
		this.createur = createur;
		this.nom = nom;
		this.date = date;
		this.description = description;
		this.lieu = lieu;
	}
	
	public Photo(Path p, AppUser createur, String nom, String description, String lieu){
		this.createur = createur;
		this.nom = nom;
		this.date = new java.util.Date();
		this.description = description;
		this.lieu = lieu;
	}
	
	public boolean ajouterPhoto (List<Photo> repertoire, Photo photo){
		return repertoire.add(photo);
	}
	
	public boolean supprimerPhoto (List <Photo> repertoire){
		return repertoire.remove(this);
	}
	
	public void modifier (String nom, String description, String lieu){
		this.setNom(nom);
		this.description = description;
		this.lieu = lieu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public AppUser getOwner(){
		return createur;
	}
}
