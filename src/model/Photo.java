package model;

import java.nio.file.Path;
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

	public AppUser getCreateur() {
		return createur;
	}
	
	public void setCreateur(AppUser createur) {
		this.createur = createur;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLieu() {
		return lieu;
	}
	
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
}
