package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Song;

public class SongRepository extends Repository<Song> {

	public SongRepository(EntityManagerFactory emf) {
		super(emf);
	}

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
