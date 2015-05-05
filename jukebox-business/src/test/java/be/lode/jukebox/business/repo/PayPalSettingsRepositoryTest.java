package be.lode.jukebox.business.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.PayPalSettings;
import be.lode.setup.ResetDBSetupLiveData;
import be.lode.setup.ResetDBSetupTestData;

public class PayPalSettingsRepositoryTest {

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
		ResetDBSetupTestData.run();
		emf = Persistence.createEntityManagerFactory("jukebox-business");
	}

	@After
	public void tearDown() throws Exception {
		ResetDBSetupLiveData.run();
	}

	@Test
	public void testPayPalSettingsRepository() {
		PayPalSettingsRepository repo = new PayPalSettingsRepository(emf);
		List<PayPalSettings> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		PayPalSettings o = new PayPalSettings();
		o = repo.save(o);
		assertTrue("save PayPalSettings", repo.getList().contains(o));
	}

	@Test
	public void testDelete() {
		Repository<PayPalSettings> repo = new PayPalSettingsRepository(emf);
		PayPalSettings o = new PayPalSettings();
		o = repo.save(o);
		assertTrue("save PayPalSettings", repo.getList().contains(o));
		assertEquals("save PayPalSettings", o, repo.find(o));
		repo.delete(o);
		assertFalse("delete PayPalSettings", repo.getList().contains(o));
		assertNull("delete PayPalSettings", repo.find(o));
	}

	@Test
	public void testFindClassOfTObject() {
		Repository<PayPalSettings> repo = new PayPalSettingsRepository(emf);
		PayPalSettings o = new PayPalSettings();
		o = repo.save(o);
		assertEquals("find PayPalSettings", o, repo.find(o));
	}

	@Test
	public void testFindT() {
		Repository<PayPalSettings> repo = new PayPalSettingsRepository(emf);
		PayPalSettings o = new PayPalSettings();
		o = repo.save(o);
		assertEquals("find PayPalSettings", o, repo.find(PayPalSettings.class,
				emf.getPersistenceUnitUtil().getIdentifier(o)));
	}

	@Test
	public void testGetList() {
		Repository<PayPalSettings> repo = new PayPalSettingsRepository(emf);
		assertNotNull("getList not null", repo.getList());
		assertTrue("getList - list not empty", repo.getList().size() > 0);
	}

	@Test
	public void testRepository() {
		Repository<PayPalSettings> repo = new PayPalSettingsRepository(emf);
		List<PayPalSettings> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		PayPalSettings o = new PayPalSettings();
		o = repo.save(o);
		assertTrue("save PayPalSettings", repo.getList().contains(o));
	}

	@Test
	public void testSave() {
		Repository<PayPalSettings> repo = new PayPalSettingsRepository(emf);
		PayPalSettings o = new PayPalSettings();
		o = repo.save(o);
		assertTrue("save PayPalSettings", repo.getList().contains(o));
		assertEquals("save PayPalSettings", o, repo.find(o));
	}

}
