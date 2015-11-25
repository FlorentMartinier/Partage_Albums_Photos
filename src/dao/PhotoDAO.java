package dao;

import javax.persistence.EntityManager;

import model.Photo;

public class PhotoDAO extends JPADao<Photo,Integer>{

	public PhotoDAO(EntityManager em) {
		super(em);
	}
}
