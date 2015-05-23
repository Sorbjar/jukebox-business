package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Jukebox;

/**
 * The Class JukeboxRepository.
 */
public class JukeboxRepository extends Repository<Jukebox> {

	/**
	 * Instantiates a new jukebox repository.
	 *
	 * @param emf
	 *            the entity manager factory
	 */
	public JukeboxRepository(EntityManagerFactory emf) {
		super(emf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see be.lode.general.repository.IRepository#getList()
	 */
	@Override
	public List<Jukebox> getList() {
		beginTransaction();
		Query query = em
				.createQuery("select jb from Jukebox jb", Jukebox.class);
		@SuppressWarnings("unchecked")
		List<Jukebox> jukeboxList = Collections.checkedList(
				query.getResultList(), Jukebox.class);
		commitTransaction();
		return jukeboxList;
	}
}
