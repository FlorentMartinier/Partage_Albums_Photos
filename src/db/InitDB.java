package db;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.openjpa.persistence.EntityManagerFactoryImpl;

import model.Album;
import model.Utilisateur;;

public class InitDB {

	
	public static void main(String[] args) {
		Utilisateur u= new Utilisateur("toto","toto@mail.fr", "Jacques");
		
		/*Album a1 = new Album("truc",u);
		Album a2=new Album("chouette",u);*/

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		/*em.persist(a1);
		em.persist(a2);$*/
		em.getTransaction().commit();
		
	}
	
	
}
