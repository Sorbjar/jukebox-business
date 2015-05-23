package be.lode.jukebox.business.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.OAuthApiInfo;

/**
 * The Class OAuthApiInfoRepository.
 */
public class OAuthApiInfoRepository extends Repository<OAuthApiInfo> {

	/**
	 * Instantiates a new o auth api info repository.
	 *
	 * @param emf
	 *            the entity manager factory
	 */
	public OAuthApiInfoRepository(EntityManagerFactory emf) {
		super(emf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see be.lode.general.repository.IRepository#getList()
	 */
	@Override
	public List<OAuthApiInfo> getList() {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("select oauth from OAuthApiInfo oauth",
				OAuthApiInfo.class);
		@SuppressWarnings("unchecked")
		List<OAuthApiInfo> oAuthApiInfoList = Collections.checkedList(
				query.getResultList(), OAuthApiInfo.class);
		tx.commit();
		em.close();
		return oAuthApiInfoList;
	}
}
