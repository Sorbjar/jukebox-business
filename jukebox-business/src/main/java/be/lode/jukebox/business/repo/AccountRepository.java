package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.Account;

public class AccountRepository extends Repository<Account> {

	public AccountRepository(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public List<Account> getList() {
		beginTransaction();
		Query query = em.createQuery("select acc from Account acc",
				Account.class);
		@SuppressWarnings("unchecked")
		List<Account> accountList = Collections.checkedList(
				query.getResultList(), Account.class);
		commitTransaction();
		return accountList;
	}

}
