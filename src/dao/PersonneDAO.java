package dao;

import javax.persistence.EntityManager;

import model.Personne;

public class PersonneDAO extends JPADao<Personne, Integer> {

	public PersonneDAO(EntityManager em) {
		super(em);
	}

}
