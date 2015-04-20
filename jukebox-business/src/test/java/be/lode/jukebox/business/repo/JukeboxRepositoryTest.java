package be.lode.jukebox.business.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Account;
import be.lode.jukebox.business.model.Jukebox;
import be.lode.setup.ResetDBSetupTestData;

public class JukeboxRepositoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ResetDBSetupTestData.run();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ResetDBSetupTestData.run();
	}
	private Account acc;

	private EntityManagerFactory emf;

	Repository<Account> aRepo;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jukebox-business");
		acc = new Account("emailAddressJukebox", "firstNameJukebox",
				"lastNameJukebox", "serviceIdJukebox", "serviceNameJukebox");
		aRepo = new AccountRepository(emf);
		acc = aRepo.save(acc);
	}

	@Test
	public void testDelete() {
		Repository<Jukebox> repo = new JukeboxRepository(emf);
		Jukebox o = new Jukebox("TestNameDelete", aRepo.find(acc));
		o = repo.save(o);
		assertTrue("save Jukebox", repo.getList().contains(o));
		assertEquals("save Jukebox", o, repo.find(o));
		repo.delete(o);
		assertFalse("delete Jukebox", repo.getList().contains(o));
		assertNull("delete Jukebox", repo.find(o));
	}

	@Test
	public void testFindClassOfTObject() {
		Repository<Jukebox> repo = new JukeboxRepository(emf);
		Jukebox o = new Jukebox("TestNameFindObj", aRepo.find(acc));
		o = repo.save(o);
		assertEquals("find Jukebox", o, repo.find(o));
	}

	@Test
	public void testFindT() {
		Repository<Jukebox> repo = new JukeboxRepository(emf);
		Jukebox o = new Jukebox("TestNameFindT", aRepo.find(acc));
		o = repo.save(o);
		assertEquals("find Jukebox", o, repo.find(Jukebox.class, emf
				.getPersistenceUnitUtil().getIdentifier(o)));
	}

	@Test
	public void testGetList() {
		Repository<Jukebox> repo = new JukeboxRepository(emf);
		assertNotNull("getList not null", repo.getList());
		assertTrue("getList - list not empty", repo.getList().size() > 0);
	}

	@Test
	public void testJukeboxRepository() {
		JukeboxRepository repo = new JukeboxRepository(emf);
		List<Jukebox> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Jukebox o = new Jukebox("TestNameRepo", acc);
		o = repo.save(o);
		assertTrue("save Jukebox", repo.getList().contains(o));
	}

	@Test
	public void testRepository() {
		Repository<Jukebox> repo = new JukeboxRepository(emf);
		List<Jukebox> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Jukebox o = new Jukebox("TestNameARepo", acc);
		o = repo.save(o);
		assertTrue("save Jukebox", repo.getList().contains(o));
	}

	@Test
	public void testSave() {
		Repository<Jukebox> repo = new JukeboxRepository(emf);
		Jukebox o = new Jukebox("TestNameSave", acc);
		o = repo.save(o);
		assertTrue("save Jukebox", repo.getList().contains(o));
		assertEquals("save Jukebox", o, repo.find(o));
	}
}
