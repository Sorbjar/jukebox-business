package be.lode.jukebox.business.model;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.lode.setup.ClearThenSetupTestDBData;

public class SongTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClearThenSetupTestDBData.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ClearThenSetupTestDBData.run();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Song.class).usingGetClass().verify();
	}

}
