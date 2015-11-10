package model;

import java.util.List;

public class Utilisateur {
	private String nom;
	private String mail;
	private String password;
	
	public Utilisateur (String nom, String mail, String password){
		this.nom = nom;
		this.mail = mail;
		this.password = password;
	}
	
	public boolean ajouter (List <Utilisateur> registre, Utilisateur utilisateur){
		return registre.add(utilisateur);
	}
	
	public boolean supprimer (List <Utilisateur> registre, Utilisateur utilisateur){
		return registre.remove(utilisateur);
	}
	
	public void modifier (String nom, String mail, String password){
		this.nom = nom;
		this.mail = mail;
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

}
