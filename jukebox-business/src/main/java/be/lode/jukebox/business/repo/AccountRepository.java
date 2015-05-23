package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Account;

/**
 * The Class AccountRepository.
 */
public class AccountRepository extends Repository<Account> {

	/**
	 * Instantiates a new account repository.
	 *
	 * @param emf
	 *            the entity manager factory
	 */
	public AccountRepository(EntityManagerFactory emf) {
		super(emf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see be.lode.general.repository.IRepository#getList()
	 */
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
