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
import be.lode.jukebox.business.Account;

public class AccountRepositoryTest {

	private EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jukebox-business");
	}

	@Test
	public void testAccountRepository() {
		AccountRepository repo = new AccountRepository(emf);
		List<Account> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Account o = new Account("emailAddressRepo", "firstNameRepo",
				"lastNameRepo", "serviceIdRepo", "serviceNameRepo");
		repo.save(o);
		assertTrue("save Account", repo.getList().contains(o));
	}

	@Test
	public void testDelete() {
		Repository<Account> repo = new AccountRepository(emf);
		Account o = new Account("emailAddressDelete", "firstNameDelete",
				"lastNameDelete", "serviceIdDelete", "serviceNameDelete");
		o = repo.save(o);
		assertTrue("save Account", repo.getList().contains(o));
		assertEquals("save Account", o, repo.find(o));
		repo.delete(o);
		assertFalse("delete Account", repo.getList().contains(o));
		assertNull("delete Account", repo.find(o));
	}

	@Test
	public void testFindClassOfTObject() {
		Repository<Account> repo = new AccountRepository(emf);
		Account o = new Account("emailAddressFindObj", "firstNameFindObj",
				"lastNameFindObj", "serviceIdFindObj", "serviceNameFindObj");
		o = repo.save(o);
		assertEquals("find Account", o, repo.find(o));
	}

	@Test
	public void testFindT() {
		Repository<Account> repo = new AccountRepository(emf);
		Account o = new Account("emailAddressFindT", "firstNameFindT",
				"lastNameFindT", "serviceIdFindT", "serviceNameFindT");
		o = repo.save(o);
		assertEquals("find Account", o, repo.find(Account.class, emf
				.getPersistenceUnitUtil().getIdentifier(o)));
	}

	@Test
	public void testGetList() {
		Repository<Account> repo = new AccountRepository(emf);
		assertNotNull("getList not null", repo.getList());
		assertTrue("getList - list not empty", repo.getList().size() > 0);
	}

	@Test
	public void testRepository() {
		Repository<Account> repo = new AccountRepository(emf);
		List<Account> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Account o = new Account("emailAddressARepo", "firstNameARepo",
				"lastNameARepo", "serviceIdARepo", "serviceNameARepo");
		repo.save(o);
		assertTrue("save Account", repo.getList().contains(o));
	}

	@Test
	public void testSave() {
		Repository<Account> repo = new AccountRepository(emf);
		Account o = new Account("emailAddressSave", "firstNameSave",
				"lastNameSave", "serviceIdSave", "serviceNameSave");
		o = repo.save(o);
		assertTrue("save Account", repo.getList().contains(o));
		assertEquals("save Account", o, repo.find(o));
	}
}
