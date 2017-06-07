package hu.api;

import junit.framework.TestCase;

public class SimcardTest extends TestCase {

	public void testToString() {
		Simcard test = new Simcard(1234,4321,12345678,87654321);
		String output = test.toString();
		assertEquals("simcard [pin1=1234, pin2=4321, puk1=12345678, puk2=87654321]", output);
	}

}
