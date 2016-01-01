package db;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.openjpa.persistence.EntityManagerFactoryImpl;

import model.Album;
import model.AppUser;

public class InitDB {

	
	public static void main(String[] args) {
		AppUser u= new AppUser("toto","toto", "Jacques", "Jacques");
		AppUser u2= new AppUser("titi","titi", "Jacques", "Jacques");

		
		//Album a1 = new Album("Album 1",u2, "description");
		//Album a2=new Album("chouette",u);

	/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.persist(a1);
		em.getTransaction().commit();
		*/
	}
	
	
}
