package be.lode.jukebox.business.model.comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.lode.setup.ResetDBSetupLiveData;
import be.lode.setup.ResetDBSetupTestData;

public class IntegerComparatorTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ResetDBSetupTestData.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ResetDBSetupLiveData.run();
	}

	@Test
	public void testCompare() {
		IntegerComparator ic = new IntegerComparator();
		Integer o1 = 0;
		Integer o2 = 0;
		assertNotEquals(-1, ic.compare(o1, o2));
		assertEquals(0, ic.compare(o1, o2));
		assertNotEquals(1, ic.compare(o1, o2));

		o1 = 5;
		o2 = 5;
		assertNotEquals(-1, ic.compare(o1, o2));
		assertEquals(0, ic.compare(o1, o2));
		assertNotEquals(1, ic.compare(o1, o2));

		o1 = -5;
		o2 = -5;
		assertNotEquals(-1, ic.compare(o1, o2));
		assertEquals(0, ic.compare(o1, o2));
		assertNotEquals(1, ic.compare(o1, o2));

		o1 = -5;
		o2 = -3;
		assertEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertNotEquals(1, ic.compare(o1, o2));

		o1 = -5;
		o2 = 0;
		assertEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertNotEquals(1, ic.compare(o1, o2));

		o1 = -5;
		o2 = 5;
		assertEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertNotEquals(1, ic.compare(o1, o2));

		o1 = -5;
		o2 = -7;
		assertNotEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertEquals(1, ic.compare(o1, o2));

		o1 = 5;
		o2 = 3;
		assertNotEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertEquals(1, ic.compare(o1, o2));

		o1 = 5;
		o2 = 0;
		assertNotEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertEquals(1, ic.compare(o1, o2));

		o1 = 5;
		o2 = -5;
		assertNotEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertEquals(1, ic.compare(o1, o2));

		o1 = 5;
		o2 = 7;
		assertEquals(-1, ic.compare(o1, o2));
		assertNotEquals(0, ic.compare(o1, o2));
		assertNotEquals(1, ic.compare(o1, o2));

	}

}
