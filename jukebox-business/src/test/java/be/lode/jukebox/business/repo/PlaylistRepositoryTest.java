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
import be.lode.jukebox.business.model.Playlist;
import be.lode.setup.ResetDBSetupLiveData;
import be.lode.setup.ResetDBSetupTestData;

public class PlaylistRepositoryTest {

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
	}

	@Test
	public void testDelete() {
		Repository<Playlist> repo = new PlaylistRepository(emf);
		Playlist o = new Playlist("testDelete");
		o = repo.save(o);
		assertTrue("save Playlist", repo.getList().contains(o));
		assertEquals("save Playlist", o, repo.find(o));
		repo.delete(o);
		assertFalse("delete Playlist", repo.getList().contains(o));
		assertNull("delete Playlist", repo.find(o));
	}

	@Test
	public void testFindClassOfTObject() {
		Repository<Playlist> repo = new PlaylistRepository(emf);
		Playlist o = new Playlist("testFindClassOfTObject");
		o = repo.save(o);
		assertEquals("find Playlist", o, repo.find(o));
	}

	@Test
	public void testFindT() {
		Repository<Playlist> repo = new PlaylistRepository(emf);
		Playlist o = new Playlist("testFindT");
		o = repo.save(o);
		assertEquals("find Playlist", o, repo.find(Playlist.class, emf
				.getPersistenceUnitUtil().getIdentifier(o)));
	}

	@Test
	public void testGetList() {
		Repository<Playlist> repo = new PlaylistRepository(emf);
		assertNotNull("getList not null", repo.getList());
		assertTrue("getList - list not empty", repo.getList().size() > 0);
	}

	@Test
	public void testPlaylistRepository() {
		PlaylistRepository repo = new PlaylistRepository(emf);
		List<Playlist> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Playlist o = new Playlist("testPlaylistRepository");
		o = repo.save(o);
		assertTrue("save Playlist", repo.getList().contains(o));
	}

	@Test
	public void testRepository() {
		Repository<Playlist> repo = new PlaylistRepository(emf);
		List<Playlist> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Playlist o = new Playlist("testRepository");
		o = repo.save(o);
		assertTrue("save Playlist", repo.getList().contains(o));
	}

	@Test
	public void testSave() {
		Repository<Playlist> repo = new PlaylistRepository(emf);
		Playlist o = new Playlist("testSave");
		o = repo.save(o);
		assertTrue("save Playlist", repo.getList().contains(o));
		assertEquals("save Playlist", o, repo.find(o));
	}

}