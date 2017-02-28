package on.uib.info233.xeq003.oblig2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Bagtest {

	private Bag<String> bag = new Bag<String>();

	@Test
	public void test() {
		assertFalse(bag.contains("hey"));
		bag.add("hey");
		assertTrue(bag.remove("hey"));
		assertEquals(bag.getCurrentSize(), 0);
		for (int i = 0; i < 11; i++){
			bag.add("hey");
		}
		assertEquals(bag.getCurrentSize(), 11);
		assertTrue(bag.remove("hey"));
		assertTrue(bag.contains("hey"));
		bag.clear();
		assertFalse(bag.contains("hey"));
	}
}