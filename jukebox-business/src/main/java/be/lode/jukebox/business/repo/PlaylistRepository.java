package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Playlist;

public class PlaylistRepository extends Repository<Playlist> {

	public PlaylistRepository(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public List<Playlist> getList() {
		beginTransaction();
		Query query = em.createQuery("select pl from Playlist pl", Playlist.class);
		@SuppressWarnings("unchecked")
		List<Playlist> accountList = Collections.checkedList(query.getResultList(),
				Playlist.class);
		commitTransaction();
		return accountList;
	}

}

