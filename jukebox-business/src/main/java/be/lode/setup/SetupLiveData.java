package be.lode.setup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Account;
import be.lode.jukebox.business.model.Currency;
import be.lode.jukebox.business.model.Jukebox;
import be.lode.jukebox.business.model.OAuthApiInfo;
import be.lode.jukebox.business.repo.AccountRepository;
import be.lode.jukebox.business.repo.CurrencyRepository;
import be.lode.jukebox.business.repo.JukeboxRepository;
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

		Currency cur = new Currency("EUR", "Euro");
		Repository<Currency> curRepo = new CurrencyRepository(emf);
		cur = curRepo.save(cur);

		Currency cur2 = new Currency("USD", "U.S. Dollar");
		cur2 = curRepo.save(cur2);

		Currency cur3 = new Currency("GBP", "Pound Sterling");
		cur3 = curRepo.save(cur3);

		JukeboxRepository jRepo = new JukeboxRepository(emf);
		Jukebox jb = new Jukebox("Fun jukebox", lod);
		jb = jRepo.save(jb);

		emf.close();
	}
}
