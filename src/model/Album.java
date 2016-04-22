package model;

import java.nio.file.Path;
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
	private Path path;

	protected Album() {
	}

	public Album(String nom, AppUser owner, String description, Path path) {
		this.nom = nom;
		this.owner = owner;
		this.description = description;
		this.date = new java.util.Date();
		owner.getMyAlbums().add(this);
		this.setPath(path);
	}

	public Album(String nom, AppUser owner, String description, Date date, List<AppUser> partage, Path path) {
		this.nom = nom;
		this.owner = owner;
		this.description = description;
		this.date = date;
		this.setPath(path);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
}
