package dao;

import javax.persistence.EntityManager;

import model.Album;

public class EvenementDAO extends JPADao<Album,Integer>  {

	public EvenementDAO(EntityManager em) {
		super(em);
	}
	
}
