package be.lode.jukebox.business;

import static org.junit.Assert.assertEquals;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

import be.lode.jukebox.business.enums.Role;

public class JukeboxTest {

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
}
