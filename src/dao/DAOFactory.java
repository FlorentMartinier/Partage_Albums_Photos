package dao;

import javax.persistence.*;

import model.Objet;

public class DAOFactory {

	private static final DAOFactory INSTANCE = new DAOFactory();
	private EntityManagerFactory emf;
	private EntityManager em;
	private UtilisateurDao utilisateurDao;
	private AlbumDao albumDao;
	private EvenementDAO evenementDao;
	private GroupeDAO groupeDao;
	private LieuDAO lieuDao;
	private ObjetDAO objetDao;
	private PersonneDAO personneDao;
	
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
	
	public EvenementDAO getEvenementDao() {
		if (evenementDao==null) {
			evenementDao=new EvenementDAO(em);
		}
		return evenementDao;
	}
	
	public GroupeDAO getGroupeDao() {
		if (groupeDao==null) {
			groupeDao=new GroupeDAO(em);
		}
		return groupeDao;
	}
	
	public LieuDAO getLieuDao() {
		if (lieuDao==null) {
			lieuDao=new LieuDAO(em);
		}
		return lieuDao;
	}
	
	public ObjetDAO getObjetDao() {
		if (objetDao==null) {
			objetDao=new ObjetDAO(em);
		}
		return objetDao;
	}
	
	public PersonneDAO getPersonneDao() {
		if (personneDao==null) {
			personneDao=new PersonneDAO(em);
		}
		return personneDao;
	}
}
