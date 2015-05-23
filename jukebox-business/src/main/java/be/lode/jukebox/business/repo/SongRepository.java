package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Song;

/**
 * The Class SongRepository.
 */
public class SongRepository extends Repository<Song> {

	/**
	 * Instantiates a new song repository.
	 *
	 * @param emf
	 *            the entity manager factory
	 */
	public SongRepository(EntityManagerFactory emf) {
		super(emf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see be.lode.general.repository.IRepository#getList()
	 */
	@Override
	public List<Song> getList() {
		beginTransaction();
		Query query = em.createQuery("select sng from Song sng", Song.class);
		@SuppressWarnings("unchecked")
		List<Song> accountList = Collections.checkedList(query.getResultList(),
				Song.class);
		commitTransaction();
		return accountList;
	}

}
