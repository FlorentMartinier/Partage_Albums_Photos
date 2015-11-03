package model;

import java.util.Date;
import java.util.List;

public class Album {
	private Utilisateur createur;
	private List<Utilisateur> partage;
	private List<Photo> photos;
	
	private String nom;
	/*private String description;*/
	private Date date;
	
	public Album(){
		
	}
	
	/*public int poid(){
		return 0;
	}*/
	
	public boolean ajouter(){
		return false;
	}
}
