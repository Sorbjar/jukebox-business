package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Playlist;

/**
 * The Class PlaylistRepository.
 */
public class PlaylistRepository extends Repository<Playlist> {

	/**
	 * Instantiates a new playlist repository.
	 *
	 * @param emf
	 *            the entity manager factory
	 */
	public PlaylistRepository(EntityManagerFactory emf) {
		super(emf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see be.lode.general.repository.IRepository#getList()
	 */
	@Override
	public List<Playlist> getList() {
		beginTransaction();
		Query query = em.createQuery("select pl from Playlist pl",
				Playlist.class);
		@SuppressWarnings("unchecked")
		List<Playlist> accountList = Collections.checkedList(
				query.getResultList(), Playlist.class);
		commitTransaction();
		return accountList;
	}

}
