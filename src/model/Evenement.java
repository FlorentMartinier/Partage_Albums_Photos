package model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Evenement extends Ressource {
	@Id
	@GeneratedValue
	private int id;
	private Date debut;
	private Date fin;
	
	public Evenement(String nom, Date debut, Date fin) {
		super(nom);
		this.debut = debut;
		this.fin = fin;
	}
	
	public boolean contient(Evenement e) {
		return debut.before(e.debut) && fin.after(e.fin);
	}
}