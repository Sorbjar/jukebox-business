package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 * The Class CustomQueryRepository.
 */
public class CustomQueryRepository {

	/** The etity manager. */
	protected EntityManager em;

	/** The entity manager factory. */
	protected EntityManagerFactory emf;

	/** The entity transaction. */
	protected EntityTransaction tx;

	/**
	 * Instantiates a new custom query repository.
	 *
	 * @param emf
	 *            the entity manager factory
	 */
	public CustomQueryRepository(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	/**
	 * Gets the all artists.
	 *
	 * @return the all artists
	 */
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

	/**
	 * Begin transaction.
	 */
	protected void beginTransaction() {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	/**
	 * Commit transaction.
	 */
	protected void commitTransaction() {
		tx.commit();
		em.close();
	}

	/**
	 * Gets the all titles. For a given artist.
	 *
	 * @param artist
	 *            the artist
	 * @return the all titles
	 */
	public List<String> getAllTitles(String artist) {
		beginTransaction();
		Query query = em
				.createQuery(
						"select distinct(sng.title) from Song sng where sng.artist = :artist order by sng.title",
						String.class);
		query.setParameter("artist", artist);
		@SuppressWarnings("unchecked")
		List<String> titleList = Collections.checkedList(query.getResultList(),
				String.class);
		commitTransaction();

		return titleList;
	}

	/**
	 * Gets the all titles.
	 *
	 * @return the all titles
	 */
	public List<String> getAllTitles() {
		beginTransaction();
		Query query = em.createQuery(
				"select distinct(sng.title) from Song sng order by sng.title",
				String.class);
		@SuppressWarnings("unchecked")
		List<String> titleList = Collections.checkedList(query.getResultList(),
				String.class);
		commitTransaction();
		return titleList;
	}
}
