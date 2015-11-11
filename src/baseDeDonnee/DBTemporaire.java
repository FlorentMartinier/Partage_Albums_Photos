package baseDeDonnee;

import java.util.*;
import model.*;

public class DBTemporaire {
	private Map<String, Utilisateur> utilisateurs;
	private Map<String, Photo> photos;
	private Map<String, Ressource> ressources;
	
	public DBTemporaire() {
		utilisateurs = new TreeMap<String, Utilisateur>();
		photos = new TreeMap<String, Photo>();
		ressources = new TreeMap<String, Ressource>();
	}
	
	public boolean add(Object o){
		if (o.getClass().equals(Utilisateur.class))
			return add((Utilisateur) o);
		if (o.getClass().equals(Photo.class))
			return add((Photo) o);
		if ((o.getClass().equals(Ressource.class)))
			return add((Ressource) o);
		return false;
	}
	
	public boolean put(Utilisateur u) {
		return this.utilisateurs.put(u.getNom(), u) != null;
	}
	
	public boolean put(Photo p) {
		return this.photos.put(p.getNom(), p) != null;
	}
	
	public boolean put(Ressource r) {
		return this.ressources.put(r.getNom(), r) != null;
	}
	
	public Utilisateur get(String nomUtilisateur){ //TODO
		return null;
	}
}
