package be.lode.setup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Account;
import be.lode.jukebox.business.model.Jukebox;
import be.lode.jukebox.business.model.OAuthApiInfo;
import be.lode.jukebox.business.model.Playlist;
import be.lode.jukebox.business.model.Song;
import be.lode.jukebox.business.repo.AccountRepository;
import be.lode.jukebox.business.repo.JukeboxRepository;
import be.lode.jukebox.business.repo.OAuthApiInfoRepository;
import be.lode.jukebox.business.repo.PlaylistRepository;
import be.lode.jukebox.business.repo.SongRepository;

public class SetupTestDBData {

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("jukebox-business");
		OAuthApiInfoRepository oaaiRepo = new OAuthApiInfoRepository(emf);
		OAuthApiInfo facebook = new OAuthApiInfo("Facebook", "FacebookApi",
				"837671609637096", "b4f77631cc7bed024d34445707c0befe",
				"https://graph.facebook.com/me");
		oaaiRepo.save(facebook);

		AccountRepository aRepo = new AccountRepository(emf);

		Account lod = new Account("lode.deckers@gmail.com", "Lode", "Deckers",
				"10153294269263586", "facebook");

		lod = aRepo.save(lod);

		JukeboxRepository jRepo = new JukeboxRepository(emf);
		Jukebox jb = new Jukebox("jbName", lod);
		jb = jRepo.save(jb);
		jRepo.delete(jb);

		Jukebox ljb = new Jukebox("lodBox", lod);
		ljb = jRepo.save(ljb);

		Song song = new Song("artist", "title", "path");
		Repository<Song> sRepo = new SongRepository(emf);
		song = sRepo.save(song);


		Repository<Playlist> plRepo = new PlaylistRepository(emf);		
		Playlist pl = new Playlist("playlist");
		pl.addSong(song);
		pl = plRepo.save(pl);

		song = sRepo.find(song);
		Playlist pl2 = new Playlist("aplaylist");
		pl2.addSong(song);
		
		Song song2 = new Song("artist2", "title2", "path2");
		song2 = sRepo.save(song2);
		pl2.addSong(song2);
		pl2 = plRepo.save(pl2);


		ljb.getSavedPlaylists().add(pl);
		ljb.getSavedPlaylists().add(pl2);
		
		ljb = jRepo.save(ljb);
		emf.close();
	}
}