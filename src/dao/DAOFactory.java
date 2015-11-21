package dao;

import javax.persistence.*;

public class DAOFactory {

	private static final DAOFactory INSTANCE = new DAOFactory();
	private EntityManagerFactory emf;
	private EntityManager em;
	private UtilisateurDao utilisateurDao;
	private AlbumDao albumDao;
	
	private DAOFactory() {
		emf = Persistence.createEntityManagerFactory("DB");
		em=emf.createEntityManager();
	}
	
	public static DAOFactory getInstance() {
		return INSTANCE;
	}
	
	public UtilisateurDao getUtilisateurDao() {
		if (utilisateurDao==null) {
			utilisateurDao=new UtilisateurDao(em);
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
