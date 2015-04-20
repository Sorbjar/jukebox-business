package be.lode.jukebox.business.model;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.lode.setup.ClearThenSetupTestDBData;

public class AccountTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClearThenSetupTestDBData.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ClearThenSetupTestDBData.run();
	}

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Account.class).usingGetClass().verify();
	}
}
