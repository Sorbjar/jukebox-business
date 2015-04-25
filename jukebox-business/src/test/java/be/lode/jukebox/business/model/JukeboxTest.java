package be.lode.jukebox.business.model;

import static org.junit.Assert.assertEquals;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.lode.jukebox.business.model.enums.Role;
import be.lode.setup.ResetDBSetupTestData;

public class JukeboxTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ResetDBSetupTestData.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ResetDBSetupTestData.run();
	}

	@Test
	public void testGetNextSong() {
		Account acc = new Account("testGetNextSonga", "testGetNextSongb",
				"testGetNextSongc", "testGetNextSongd", "testGetNextSonge");
		Jukebox o = new Jukebox("testGetNextSong", acc);

		String artist = "s1" + "artist";
		String title = "s1" + "title";
		String path = "s1" + "path";

		Song s1 = new Song(artist, title, path);

		artist = "s2" + "artist";
		title = "s2" + "title";
		path = "s2" + "path";

		Song s2 = new Song(artist, title, path);

		artist = "s3" + "artist";
		title = "s3" + "title";
		path = "s3" + "path";

		Song s3 = new Song(artist, title, path);

		o.getCurrentPlaylist().addSong(s1);
		o.getCurrentPlaylist().addSong(s2);
		o.getCurrentPlaylist().addSong(s3);

		assertEquals(s2, o.getNextSong(0));

		artist = "s4" + "artist";
		title = "s4" + "title";
		path = "s4" + "path";

		Song s4 = new Song(artist, title, path);

		o.getMandatoryPlaylist().addSong(s4);

		assertEquals(s4, o.getNextSong(0));
		assertEquals(s4, o.getNextSong(1));
		assertEquals(s4, o.getNextSong(2));
	}
	
	
	@Test
	public void testGetPreviousSong() {
		Account acc = new Account("testGetPreviousSonga", "testGetPreviousSongb",
				"testGetPreviousSongc", "testGetPreviousSongd", "testGetPreviousSonge");
		Jukebox o = new Jukebox("testGetPreviousSong", acc);

		String artist = "s1" + "artist";
		String title = "s1" + "title";
		String path = "s1" + "path";

		Song s1 = new Song(artist, title, path);

		artist = "s2" + "artist";
		title = "s2" + "title";
		path = "s2" + "path";

		Song s2 = new Song(artist, title, path);

		artist = "s3" + "artist";
		title = "s3" + "title";
		path = "s3" + "path";

		Song s3 = new Song(artist, title, path);

		o.getCurrentPlaylist().addSong(s1);
		o.getCurrentPlaylist().addSong(s2);
		o.getCurrentPlaylist().addSong(s3);

		assertEquals(s1, o.getPreviousSong(1));

		artist = "s4" + "artist";
		title = "s4" + "title";
		path = "s4" + "path";

		Song s4 = new Song(artist, title, path);

		o.getMandatoryPlaylist().addSong(s4);

		assertEquals(s4, o.getPreviousSong(0));
		assertEquals(s4, o.getPreviousSong(1));
		assertEquals(s4, o.getPreviousSong(2));
	}

	@Test
	public void testAddAccountRole() {

		Account acc = new Account("a", "b", "c", "d", "e");
		Jukebox o = new Jukebox("jbName", acc);

		Account acc2 = new Account("a2", "b2", "c2", "d2", "e2");
		assertEquals("starting number of accounts 1", 1, o.getAccountRoles()
				.size());
		assertEquals("starting account is of type administrator",
				Role.Administrator, o.getAccountRoles().get(acc));
		o.addAccountRole(acc2, Role.Manager);
		assertEquals("current number of accounts 2", 2, o.getAccountRoles()
				.size());
		assertEquals("new account is of type Manager", Role.Manager, o
				.getAccountRoles().get(acc2));
		o.addAccountRole(acc2, Role.Administrator);
		assertEquals("new account is of type Administrator",
				Role.Administrator, o.getAccountRoles().get(acc2));
	}

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Jukebox.class).usingGetClass().verify();
	}

	@Test
	public void testJukebox() {
		Account acc = new Account("a", "b", "c", "d", "e");
		Jukebox o = new Jukebox("jbName", acc);
		assertEquals("getName Expecting jbName", "jbName", o.getName());
	}
}
