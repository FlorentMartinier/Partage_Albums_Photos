package dao;

import javax.persistence.EntityManager;

import model.Groupe;

public class GroupeDAO extends JPADao<Groupe, Integer> {

	public GroupeDAO(EntityManager em) {
		super(em);
	}

}
