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
import be.lode.jukebox.business.model.Song;
import be.lode.setup.ResetDBSetupTestData;

public class SongRepositoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ResetDBSetupTestData.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ResetDBSetupTestData.run();
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
		Repository<Song> repo = new SongRepository(emf);
		Song o = new Song("testDelete", "111", "222");
		o = repo.save(o);
		assertTrue("save Song", repo.getList().contains(o));
		assertEquals("save Song", o, repo.find(o));
		repo.delete(o);
		assertFalse("delete Song", repo.getList().contains(o));
		assertNull("delete Song", repo.find(o));
	}

	@Test
	public void testFindClassOfTObject() {
		Repository<Song> repo = new SongRepository(emf);
		Song o = new Song("testFindClassOfTObject", "111", "222");
		o = repo.save(o);
		assertEquals("find Song", o, repo.find(o));
	}

	@Test
	public void testFindT() {
		Repository<Song> repo = new SongRepository(emf);
		Song o = new Song("testFindT", "111", "222");
		o = repo.save(o);
		assertEquals("find Song", o, repo.find(Song.class, emf
				.getPersistenceUnitUtil().getIdentifier(o)));
	}

	@Test
	public void testGetList() {
		Repository<Song> repo = new SongRepository(emf);
		assertNotNull("getList not null", repo.getList());
		assertTrue("getList - list not empty", repo.getList().size() > 0);
	}

	@Test
	public void testRepository() {
		Repository<Song> repo = new SongRepository(emf);
		List<Song> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Song o = new Song("testRepository", "111", "222");
		o = repo.save(o);
		assertTrue("save Song", repo.getList().contains(o));
	}

	@Test
	public void testSave() {
		Repository<Song> repo = new SongRepository(emf);
		Song o = new Song("testSave", "111", "222");
		o = repo.save(o);
		assertTrue("save Song", repo.getList().contains(o));
		assertEquals("save Song", o, repo.find(o));
	}

	@Test
	public void testSongRepository() {
		SongRepository repo = new SongRepository(emf);
		List<Song> list = repo.getList();
		assertNotNull("getList not null", list);
		assertTrue("getList - list not empty", list.size() > 0);
		Song o = new Song("testSongRepository", "111", "222");
		o = repo.save(o);
		assertTrue("save Song", repo.getList().contains(o));
	}

}