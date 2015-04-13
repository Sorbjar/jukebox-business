package be.lode.jukebox.business.repo;

import static org.junit.Assert.assertNotNull;
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
	public void testOAuthApiInfoRepository() {
		Repository<OAuthApiInfo> oaaiRepo = new OAuthApiInfoRepository(emf);

		List<OAuthApiInfo> list = oaaiRepo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		oaaiRepo.save(o);
		assertTrue("save OAuthApiInfo", oaaiRepo.getList().contains(o));
	}

	@Test
	public void testGetList() {
		Repository<OAuthApiInfo> oaaiRepo = new OAuthApiInfoRepository(emf);
		assertNotNull("getList not null", oaaiRepo.getList());
		assertTrue("getList - list not empty", oaaiRepo.getList().size() > 0);

	}

	@Test
	public void testSaveOAuthApiInfo() {
		OAuthApiInfoRepository oaaiRepo = new OAuthApiInfoRepository(emf);
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		oaaiRepo.save(o);
		assertTrue("save OAuthApiInfo", oaaiRepo.getList().contains(o));
	}

	@Test
	public void testRepository() {
		Repository<OAuthApiInfo> rep = new OAuthApiInfoRepository(emf);
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		rep.save(o);
		assertTrue("save OAuthApiInfo", rep.getList().contains(o));
	}

	@Test
	public void testGetListAbstract() {
		Repository<OAuthApiInfo> rep = new OAuthApiInfoRepository(emf);
		assertNotNull("getList not null", rep.getList());
		assertTrue("getList - list not empty", rep.getList().size() > 0);
	}

	@Test
	public void testSaveT() {
		Repository<OAuthApiInfo> rep = new OAuthApiInfoRepository(emf);
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		rep.save(o);
		assertTrue("save OAuthApiInfo", rep.getList().contains(o));
	}

}
