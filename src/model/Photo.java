package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Photo {
	private Utilisateur createur;
	private List<Utilisateur> partage; // liste d'utilisateur à qui la photo est partagée
	
	private String nom;
	private Date date;
	private String description;
	private Lieu lieu;
	private List <Personne> personne; // personnes tagées sur la photo
	private List <Objet> objet;
	
	public Photo(Utilisateur createur, String nom, Date date, String description, String lieu){
		this.createur = createur;
		this.partage = new ArrayList ();
		this.nom = nom;
		this.date = date;
		this.description = description;
		this.lieu = new Lieu(lieu);
		this.personne = new ArrayList ();
		this.objet = new ArrayList();
	}
	
	public boolean ajouterPhoto (List<Photo> repertoire, Photo photo){
		return repertoire.add(photo);
	}
	
	public boolean supprimerPhoto (List <Photo> repertoire){
		return repertoire.remove(this);
	}
	
	public boolean ajouterPersonne (Personne personne){
		return this.personne.add(personne);
	}
	
	public boolean supprimerPersonne (Personne personne){
		return this.personne.remove(personne);
	}
	
	public boolean ajouterObjet (Objet objet){
		return this.objet.add(objet);
	}
	
	public boolean supprimerObjet (Objet objet){
		return this.objet.remove(objet);
	}
	
	public void modifier (String nom, String description, Lieu lieu){
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
}
