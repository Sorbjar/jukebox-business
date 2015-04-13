package be.lode.jukebox.business;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class AccountTest {
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Account.class).usingGetClass().verify();
	}
}
