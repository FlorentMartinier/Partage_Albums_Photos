package model;

import java.util.Date;

public class Evenement extends Ressource {
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
