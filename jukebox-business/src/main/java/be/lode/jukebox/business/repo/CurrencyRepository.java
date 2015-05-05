package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Currency;

public class CurrencyRepository extends Repository<Currency> {

	public CurrencyRepository(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public List<Currency> getList() {
		beginTransaction();
		Query query = em.createQuery("select cur from Currency cur",
				Currency.class);
		@SuppressWarnings("unchecked")
		List<Currency> currencyList = Collections.checkedList(
				query.getResultList(), Currency.class);
		commitTransaction();
		return currencyList;
	}

}
