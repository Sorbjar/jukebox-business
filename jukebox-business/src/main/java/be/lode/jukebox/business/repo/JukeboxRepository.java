package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.Jukebox;

//TODO testing
public class JukeboxRepository extends Repository<Jukebox> {

	public JukeboxRepository(EntityManagerFactory emf) {
		super(emf);
	}

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
