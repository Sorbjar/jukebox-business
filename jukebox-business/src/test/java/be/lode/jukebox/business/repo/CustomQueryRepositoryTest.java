package be.lode.jukebox.business.repo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class CustomQueryRepositoryTest {

	private EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jukebox-business");
	}

	@Test
	public void testGetAllArtists() {
		CustomQueryRepository repo = new CustomQueryRepository(emf);
		List<String> list = repo.getAllArtists();
		assertNotNull(list);
		assertTrue(list.size() > 0);
		for (String string : list) {
			assertNotNull(string);
		}
	}

	@Test
	public void testGetAllTitlesArtist() {
		CustomQueryRepository repo = new CustomQueryRepository(emf);
		List<String> alist = repo.getAllArtists();
		assertNotNull(alist);
		assertTrue(alist.size() > 0);
		for (String artist : alist) {
			List<String> tlist = repo.getAllTitles(artist);
			assertNotNull(tlist);
			assertTrue(tlist.size() > 0);
			for (String title : tlist) {
				assertNotNull(title);
			}
		}
	}

	@Test
	public void testGetAllTitles() {
		CustomQueryRepository repo = new CustomQueryRepository(emf);

		List<String> tlist = repo.getAllTitles();
		assertNotNull(tlist);
		assertTrue(tlist.size() > 0);
		for (String title : tlist) {
			assertNotNull(title);
		}

	}

}
