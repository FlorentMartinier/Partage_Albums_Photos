package model;

import java.util.*;

import javax.persistence.*;

@Entity
public class AppUser {

	@Id
	private String login;
	private String password;
	
	private String prenom;
	private String nom;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Album> myAlbums;

	
	protected AppUser() {}

	public AppUser(String login, String password, String nom, String prenom) {
		this.login=login;
		this.password=password;
		this.nom=nom;
		this.prenom=prenom;
		myAlbums = new ArrayList<Album>();
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password; 
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom; 
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Album> getMyAlbums() {
		return myAlbums;
	}
	
}
