package be.lode.jukebox.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class OAuthApiInfoTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(OAuthApiInfo.class).usingGetClass().verify();
	}

	@Test
	public void testGetApiKey() {
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		assertEquals("getApiKey Expecting TestKey", "TestKey", o.getApiKey());
	}

	@Test
	public void testGetApiSecret() {
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		assertEquals("getApiSecret Expecting TestSecret", "TestSecret",
				o.getApiSecret());
	}

	@Test
	public void testGetExampleGetRequest() {
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		assertEquals("getExampleGetRequest Expecting TestURL", "TestURL",
				o.getExampleGetRequest());
	}

	@Test
	public void testGetName() {
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		assertEquals("getName Expecting TestName", "TestName", o.getName());
	}

	@Test
	public void testGetScribeApi() {
		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		assertEquals("getScribeApi Expecting FacebookApi.class", "FacebookApi",
				o.getScribeApiName());
	}

	@Test
	public void testOAuthApiInfo() {
		OAuthApiInfo o = new OAuthApiInfo();
		assertNull("Empty Constructor, expect null", o.getApiKey());
		assertNull("Empty Constructor, expect null", o.getName());
		assertNull("Empty Constructor, expect null", o.getApiSecret());
		assertNull("Empty Constructor, expect null", o.getExampleGetRequest());
		assertNull("Empty Constructor, expect null", o.getScribeApiName());
	}

	@Test
	public void testOAuthApiInfoStringClassOfQextendsApiStringStringString() {

		OAuthApiInfo o = new OAuthApiInfo("TestName", "FacebookApi", "TestKey",
				"TestSecret", "TestURL");
		assertEquals("getName Expecting TestName", "TestName", o.getName());
		assertEquals("getScribeApi Expecting FacebookApi.class", "FacebookApi",
				o.getScribeApiName());
		assertEquals("getApiKey Expecting TestKey", "TestKey", o.getApiKey());
		assertEquals("getApiSecret Expecting TestSecret", "TestSecret",
				o.getApiSecret());
		assertEquals("getExampleGetRequest Expecting TestURL", "TestURL",
				o.getExampleGetRequest());
	}

}
