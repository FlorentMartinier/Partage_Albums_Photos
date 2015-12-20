package dao;

import javax.persistence.EntityManager;

import org.apache.openjpa.kernel.Query;

import model.AppUser;

public class AppUserDao extends JPADao<AppUser,String>{

	public AppUserDao(EntityManager em) {
		super(em);
	}
	
}
