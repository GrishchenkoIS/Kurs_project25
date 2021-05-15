package kurs25;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestFlodPoint {
	static boolean correct = false;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		double value = 74.56767876456;
		double out = CalculationC.FlodPoint(value);
		if (out == 74.57) {
		correct = true;
		}
	}

	@Test
	public void test() {
		assertTrue(correct);;
	}

}
