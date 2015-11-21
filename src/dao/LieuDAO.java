package dao;

import javax.persistence.EntityManager;

import model.Lieu;

public class LieuDAO extends JPADao<Lieu, Integer> {

	public LieuDAO(EntityManager em) {
		super(em);
	}

}
