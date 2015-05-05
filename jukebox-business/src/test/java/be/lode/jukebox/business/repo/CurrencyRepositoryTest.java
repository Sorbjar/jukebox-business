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
import be.lode.jukebox.business.model.Currency;
import be.lode.setup.ResetDBSetupLiveData;
import be.lode.setup.ResetDBSetupTestData;

public class CurrencyRepositoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ResetDBSetupTestData.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ResetDBSetupLiveData.run();
	}

	private EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jukebox-business");
	}

	@Test
	public void testCurrencyRepository() {
		CurrencyRepository repo = new CurrencyRepository(emf);
		List<Currency> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Currency o = new Currency("ILS","Israeli New Sheqel");
		o = repo.save(o);
		assertTrue("save Currency", repo.getList().contains(o));
	}

	@Test
	public void testDelete() {
		Repository<Currency> repo = new CurrencyRepository(emf);
		Currency o = new Currency("ILS","Israeli New Sheqel");
		o = repo.save(o);
		assertTrue("save Currency", repo.getList().contains(o));
		assertEquals("save Currency", o, repo.find(o));
		repo.delete(o);
		assertFalse("delete Currency", repo.getList().contains(o));
		assertNull("delete Currency", repo.find(o));
	}

	@Test
	public void testFindClassOfTObject() {
		Repository<Currency> repo = new CurrencyRepository(emf);
		Currency o = new Currency("ILS","Israeli New Sheqel");
		o = repo.save(o);
		assertEquals("find Currency", o, repo.find(o));
	}

	@Test
	public void testFindT() {
		Repository<Currency> repo = new CurrencyRepository(emf);
		Currency o = new Currency("ILS","Israeli New Sheqel");
		o = repo.save(o);
		assertEquals("find Currency", o, repo.find(Currency.class, emf
				.getPersistenceUnitUtil().getIdentifier(o)));
	}

	@Test
	public void testGetList() {
		Repository<Currency> repo = new CurrencyRepository(emf);
		assertNotNull("getList not null", repo.getList());
		assertTrue("getList - list not empty", repo.getList().size() > 0);
	}

	@Test
	public void testRepository() {
		Repository<Currency> repo = new CurrencyRepository(emf);
		List<Currency> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Currency o = new Currency("ILS","Israeli New Sheqel");
		repo.save(o);
		assertTrue("save Currency", repo.getList().contains(o));
	}

	@Test
	public void testSave() {
		Repository<Currency> repo = new CurrencyRepository(emf);
		Currency o = new Currency("ILS","Israeli New Sheqel");
		o = repo.save(o);
		assertTrue("save Currency", repo.getList().contains(o));
		assertEquals("save Currency", o, repo.find(o));
	}

}
