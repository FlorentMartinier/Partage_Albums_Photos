package dao;

import javax.persistence.EntityManager;

import model.Objet;

public class ObjetDAO extends JPADao<Objet, Integer> {

	public ObjetDAO(EntityManager em) {
		super(em);
	}

}
