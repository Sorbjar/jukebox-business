package be.lode.jukebox.business.idClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

public class AccountIdTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(AccountId.class).usingGetClass().suppress(Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void testAccountId() {
		AccountId o = new AccountId();
		assertNotNull(o);
		assertNull(o.getService());
		assertNull(o.getServiceId());
	}

	@Test
	public void testAccountIdStringString() {
		AccountId o = new AccountId("a","b");
		assertEquals("getService Expecting a", "a", o.getService());
		assertEquals("getServiceId Expecting b", "b", o.getServiceId());
		assertNotNull(o);
	}

	@Test
	public void testGetService() {
		AccountId o = new AccountId("a","b");
		assertEquals("getService Expecting a", "a", o.getService());
	}

	@Test
	public void testGetServiceId() {
		AccountId o = new AccountId("a","b");
		assertEquals("getServiceId Expecting b", "b", o.getServiceId());
	}

}
