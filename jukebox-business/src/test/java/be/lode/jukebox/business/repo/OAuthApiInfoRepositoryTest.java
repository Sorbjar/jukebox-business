package be.lode.jukebox.business.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.OAuthApiInfo;

public class OAuthApiInfoRepositoryTest {

	private EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jukebox-business");
	}

	@Test
	public void testDelete() {
		Repository<OAuthApiInfo> repo = new OAuthApiInfoRepository(emf);
		OAuthApiInfo o = new OAuthApiInfo("TestNameDelete",
				"FacebookApiDelete", "TestKeyDelete", "TestSecretDelete",
				"TestURLDelete");
		o = repo.save(o);
		assertTrue("save OAuthApiInfo", repo.getList().contains(o));
		assertEquals("save OAuthApiInfo", o, repo.find(o));
		repo.delete(o);
		assertFalse("delete OAuthApiInfo", repo.getList().contains(o));
		assertNull("delete OAuthApiInfo", repo.find(o));
	}

	@Test
	public void testFindClassOfTObject() {
		Repository<OAuthApiInfo> repo = new OAuthApiInfoRepository(emf);
		OAuthApiInfo o = new OAuthApiInfo("TestNameFindObj",
				"FacebookApiFindObj", "TestKeyFindObj", "TestSecretFindObj",
				"TestURLFindObj");
		o = repo.save(o);
		assertEquals("find OAuthApiInfo", o, repo.find(o));
	}

	@Test
	public void testFindT() {
		Repository<OAuthApiInfo> repo = new OAuthApiInfoRepository(emf);
		OAuthApiInfo o = new OAuthApiInfo("TestNameFindT", "FacebookApiFindT",
				"TestKeyFindT", "TestSecretFindT", "TestURLFindT");
		o = repo.save(o);
		assertEquals("find OAuthApiInfo", o, repo.find(OAuthApiInfo.class, emf
				.getPersistenceUnitUtil().getIdentifier(o)));
	}

	@Test
	public void testGetList() {
		Repository<OAuthApiInfo> repo = new OAuthApiInfoRepository(emf);
		assertNotNull("getList not null", repo.getList());
		assertTrue("getList - list not empty", repo.getList().size() > 0);
	}

	@Test
	public void testOAuthApiInfoRepository() {
		OAuthApiInfoRepository repo = new OAuthApiInfoRepository(emf);
		List<OAuthApiInfo> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);

		OAuthApiInfo o = new OAuthApiInfo("TestNameRepo", "FacebookApiRepo",
				"TestKeyRepo", "TestSecretRepo", "TestURLRepo");
		repo.save(o);
		assertTrue("save OAuthApiInfo", repo.getList().contains(o));
	}

	@Test
	public void testRepository() {
		Repository<OAuthApiInfo> repo = new OAuthApiInfoRepository(emf);
		List<OAuthApiInfo> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		OAuthApiInfo o = new OAuthApiInfo("TestNameARepo", "FacebookApiARepo",
				"TestKeyARepo", "TestSecretARepo", "TestURLARepo");
		repo.save(o);
		assertTrue("save OAuthApiInfo", repo.getList().contains(o));
	}

	@Test
	public void testSave() {
		Repository<OAuthApiInfo> repo = new OAuthApiInfoRepository(emf);
		OAuthApiInfo o = new OAuthApiInfo("TestNameSave", "FacebookApiSave",
				"TestKeySave", "TestSecretSave", "TestURLSave");
		o = repo.save(o);
		assertTrue("save OAuthApiInfo", repo.getList().contains(o));
		assertEquals("save OAuthApiInfo", o, repo.find(o));
	}
}
