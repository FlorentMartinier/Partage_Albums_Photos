package dao;

import javax.persistence.*;

public class DAOFactory {

	private static final DAOFactory INSTANCE = new DAOFactory();
	private EntityManagerFactory emf;
	private EntityManager em;
	private AppUserDao utilisateurDao;
	private AlbumDao albumDao;
	
	
	private DAOFactory() {
		emf = Persistence.createEntityManagerFactory("DB");
		em=emf.createEntityManager();
	}
	
	public static DAOFactory getInstance() {
		return INSTANCE;
	}
	
	public AppUserDao getAppUserDao() {
		if (utilisateurDao==null) {
			utilisateurDao=new AppUserDao(em);
		}
		return utilisateurDao;
	}
	
	public AlbumDao getAlbumDao() {
		if (albumDao==null) {
			albumDao=new AlbumDao(em);
		}
		return albumDao;
	}
	
}
