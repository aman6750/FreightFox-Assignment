package com.masai.junit_example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testDivisionOfInteger() {
		
		MathUtils mu = new MathUtils();
		
		assertEquals(5, mu.divisionOfInteger(10, 2));
		assertEquals(2, mu.divisionOfInteger(18, 7));
		
	}
	
	@Test
	void testDivisionOfIntegerForNegativeNumber() {
		
		MathUtils mu = new MathUtils();
		
		assertEquals(-5, mu.divisionOfInteger(-10, 2));
		assertEquals(2, mu.divisionOfInteger(-18, -7));
		
	}
	
	@Test
	void testDivisionOfIntegerForExceptions() {
		
		MathUtils mu = new MathUtils();
		
		assertThrows(ArithmeticException.class,()-> mu.divisionOfInteger(10, 0));  // 10,0 --> AE
		assertThrows(ArithmeticException.class,()-> mu.divisionOfInteger(0, 0)); // 0,0 --> AE
	}
	
	
	@Test
	void testDivisionOfDouble() {
		
		MathUtils mu = new MathUtils();
		
		assertTrue(Double.isInfinite(mu.divisionOfDouble(10.0, 0.0)));
		assertTrue(Double.valueOf(mu.divisionOfDouble(0.0, 0.0)).isNaN());
		
						
	}
	
	

}
