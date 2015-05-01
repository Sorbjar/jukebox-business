package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class CustomQueryRepository {
	protected EntityManager em;
	protected EntityManagerFactory emf;
	protected EntityTransaction tx;

	public CustomQueryRepository(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public List<String> getAllArtists() {
		beginTransaction();
		Query query = em.createQuery(
				"select distinct(sng.artist) from Song sng order by artist",
				String.class);
		@SuppressWarnings("unchecked")
		List<String> artistList = Collections.checkedList(
				query.getResultList(), String.class);
		commitTransaction();
		return artistList;
	}

	protected void beginTransaction() {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	protected void commitTransaction() {
		tx.commit();
		em.close();
	}

	public List<String> getAllTitles(String artist) {
		beginTransaction();
		Query query = em
				.createQuery(
						"select distinct(sng.title) from Song sng where sng.artist = :artist order by artist",
						String.class);
		query.setParameter("artist", artist);
		@SuppressWarnings("unchecked")
		List<String> titleList = Collections.checkedList(query.getResultList(),
				String.class);
		commitTransaction();
		return titleList;
	}

	public List<String> getAllTitles() {
		beginTransaction();
		Query query = em.createQuery(
				"select distinct(sng.title) from Song sng order by title",
				String.class);
		@SuppressWarnings("unchecked")
		List<String> titleList = Collections.checkedList(query.getResultList(),
				String.class);
		commitTransaction();
		return titleList;
	}

	// TODO 010 testing
	public List<String> getAllJukeboxes() {
		beginTransaction();
		Query query = em.createQuery(
				"select distinct(jb.name) from Jukebox jb order by jb.name",
				String.class);
		@SuppressWarnings("unchecked")
		List<String> jukeboxList = Collections.checkedList(
				query.getResultList(), String.class);
		commitTransaction();
		return jukeboxList;
	}
}
