package be.lode.jukebox.business.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlaylistTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddSong() {
		Playlist pl = new Playlist("tst");
		assertNotNull("Playlist songcollection not null", pl.getSongs());
		assertEquals("Playlist is empty", 0, pl.getSongs().size());
		Song s1 = new Song("aaa", "bbb", "ccc");
		pl.addSong(s1);
		assertTrue("Playlist is not empty", pl.getSongs().size() > 0);
		assertEquals("Playlist is size 1 ", 1, pl.getSongs().size());
		assertEquals("Playlist object on correct index ", s1, pl.getSongs()
				.get(0));
		Song s2 = new Song("aaaa", "bbbb", "cccc");
		pl.addSong(s2);
		assertTrue("Playlist is not empty", pl.getSongs().size() > 0);
		assertEquals("Playlist is size 2 ", 2, pl.getSongs().size());
		assertEquals("Playlist object on correct index ", s2, pl.getSongs()
				.get(1));
	}

	@Test
	public void testRemoveSong() {
		Playlist pl = new Playlist("tst");
		assertNotNull("Playlist songcollection not null", pl.getSongs());
		assertEquals("Playlist is empty", 0, pl.getSongs().size());
		Song s1 = new Song("aaa", "bbb", "ccc");
		pl.addSong(s1);
		assertTrue("Playlist is not empty", pl.getSongs().size() > 0);
		assertEquals("Playlist is size 1 ", 1, pl.getSongs().size());
		assertEquals("Playlist object on correct index ", s1, pl.getSongs()
				.get(0));
		Song s2 = new Song("aaaa", "bbbb", "cccc");
		pl.addSong(s2);
		assertTrue("Playlist is not empty", pl.getSongs().size() > 0);
		assertEquals("Playlist is size 2 ", 2, pl.getSongs().size());
		assertEquals("Playlist object on correct index ", s2, pl.getSongs()
				.get(1));
		pl.removeSong(0);
		assertTrue("Playlist is not empty", pl.getSongs().size() > 0);
		assertEquals("Playlist is size 1 ", 1, pl.getSongs().size());
		assertEquals("Playlist object on correct index ", s2, pl.getSongs()
				.get(0));
		pl.removeSong(0);

		assertNotNull("Playlist songcollection not null", pl.getSongs());
		assertEquals("Playlist is empty", 0, pl.getSongs().size());
	}
	
	@Test
	public void testToString() {
		Playlist pl = new Playlist("tst");
		assertEquals("Tostring","tst", pl.toString());
		pl.setName("newTest");
		assertEquals("Tostring","newTest", pl.toString());
	}

	@Test
	public void testMoveSong() {
		Playlist pl = new Playlist("tst");
		assertNotNull("Playlist songcollection not null", pl.getSongs());
		assertEquals("Playlist is empty", 0, pl.getSongs().size());
		Song s1 = new Song("1aaa", "1bbb", "1ccc");
		pl.addSong(s1);
		assertTrue("Playlist is not empty", pl.getSongs().size() > 0);
		assertEquals("Playlist is size 1 ", 1, pl.getSongs().size());
		assertEquals("Playlist object on correct index ", s1, pl.getSongs()
				.get(0));
		Song s2 = new Song("2aaa", "2bbb", "2ccc");
		pl.addSong(s2);
		Song s3 = new Song("3aaa", "3bbb", "3ccc");
		pl.addSong(s3);
		Song s4 = new Song("4aaa", "4bbb", "4ccc");
		pl.addSong(s4);
		Song s5 = new Song("5aaa", "5bbb", "5ccc");
		pl.addSong(s5);
		assertEquals("Playlist object on correct index ", s1, pl.getSongs()
				.get(0));
		assertEquals("Playlist object on correct index ", s2, pl.getSongs()
				.get(1));
		assertEquals("Playlist object on correct index ", s3, pl.getSongs()
				.get(2));
		assertEquals("Playlist object on correct index ", s4, pl.getSongs()
				.get(3));
		assertEquals("Playlist object on correct index ", s5, pl.getSongs()
				.get(4));
		pl.moveSong(3, 1);
		assertEquals("Playlist object on correct index ", s1, pl.getSongs()
				.get(0));
		assertEquals("Playlist object on correct index ", s2, pl.getSongs()
				.get(2));
		assertEquals("Playlist object on correct index ", s3, pl.getSongs()
				.get(3));
		assertEquals("Playlist object on correct index ", s4, pl.getSongs()
				.get(1));
		assertEquals("Playlist object on correct index ", s5, pl.getSongs()
				.get(4));
	}

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Playlist.class).usingGetClass().verify();
	}

}
