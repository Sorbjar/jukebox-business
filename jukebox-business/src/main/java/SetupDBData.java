import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.lode.jukebox.business.Account;
import be.lode.jukebox.business.Jukebox;
import be.lode.jukebox.business.OAuthApiInfo;
import be.lode.jukebox.business.repo.AccountRepository;
import be.lode.jukebox.business.repo.JukeboxRepository;
import be.lode.jukebox.business.repo.OAuthApiInfoRepository;

public class SetupDBData {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("jukebox-business");
		OAuthApiInfoRepository oaaiRepo = new OAuthApiInfoRepository(emf);
		OAuthApiInfo facebook = new OAuthApiInfo("Facebook", "FacebookApi",
				"837671609637096", "b4f77631cc7bed024d34445707c0befe",
				"https://graph.facebook.com/me");
		oaaiRepo.save(facebook);

		AccountRepository aRepo = new AccountRepository(emf);
		Account acc = new Account("a", "b", "c", "d", "e");
		acc = aRepo.save(acc);
		
		JukeboxRepository jRepo = new JukeboxRepository(emf);
		Jukebox jb = new Jukebox("jbName", acc);
		jb = jRepo.save(jb);
		//jRepo.delete(jb);
	}
}
