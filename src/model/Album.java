package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Album {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nom;
	private String description;
	private Date date;
	
	@ManyToOne
	private AppUser owner;

	protected Album() {}
	
	public Album(String nom, AppUser owner, String description) {
		this.nom=nom;
		this.owner=owner;
		this.description = description;
		this.date=new java.util.Date();
		owner.getMyAlbums().add(this);
	}
	
	public Album(String nom, AppUser owner, String description, Date date, List <AppUser> partage){
		this.nom=nom;
		this.owner=owner;
		this.description = description;
		this.date=date;
	}
		
	public AppUser getOwner() {
		return owner;
	}

	public void setOwner(AppUser owner) {
		this.owner = owner;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
