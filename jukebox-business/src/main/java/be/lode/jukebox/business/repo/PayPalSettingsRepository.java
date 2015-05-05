package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.PayPalSettings;

public class PayPalSettingsRepository extends Repository<PayPalSettings> {

	public PayPalSettingsRepository(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public List<PayPalSettings> getList() {
		beginTransaction();
		Query query = em.createQuery("select pay from PayPalSettings pay",
				PayPalSettings.class);
		@SuppressWarnings("unchecked")
		List<PayPalSettings> payPalSettingsList = Collections.checkedList(
				query.getResultList(), PayPalSettings.class);
		commitTransaction();
		return payPalSettingsList;
	}

}
