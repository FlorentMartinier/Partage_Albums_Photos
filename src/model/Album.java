package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
	private Utilisateur createur;
	private List<Utilisateur> partage; // liste d'utilisateur à qui l'album est partagé
	private List<Photo> photos;
	
	private String nom;
	private Date date;
	private String description;
	private int nbPhotos;
	
	public Album(Utilisateur createur, String nom, Date date, String description){ // créé un nouvel album vide
		this.createur = createur;
		this.partage = new ArrayList();
		this.photos = new ArrayList();
		this.nom = nom;
		this.date = date;
		this.description = description;
		this.nbPhotos=0;
	}
	
	// Ajoute un Album dans le répertoire d'album
	public boolean ajouter(List<Album> repertoire, Utilisateur createur, String nom, Date date, String description){
		nbPhotos++;
		return repertoire.add(new Album (createur, nom, date, description));
	}
	
	// Supprime un Album du répertoire d'album
	public boolean supprimer (List <Album> repertoire, Album albumToRemove){
		nbPhotos--;
		return repertoire.remove(albumToRemove);
	}
	
	// Modifie un Album du repertoire
	public void modifier (String nom, String description){
		this.nom = nom;
		this.description = description;
	}
}
