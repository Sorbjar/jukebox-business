package be.lode.setup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.lode.jukebox.business.model.Account;
import be.lode.jukebox.business.model.OAuthApiInfo;
import be.lode.jukebox.business.repo.AccountRepository;
import be.lode.jukebox.business.repo.OAuthApiInfoRepository;

public class SetupLiveData {

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
		emf.close();
	}
}
