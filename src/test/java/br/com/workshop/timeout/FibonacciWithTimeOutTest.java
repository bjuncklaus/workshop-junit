package br.com.workshop.timeout;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import br.com.workshop.code.Fibonacci;
import br.com.workshop.interfaces.FastTests;
import br.com.workshop.interfaces.SlowTests;

@Category({SlowTests.class, FastTests.class})
public class FibonacciWithTimeOutTest {

	private Fibonacci fibonacci;
	
	@Before
	public void setUp() {
		fibonacci = new Fibonacci();
	}
	
	@Test(timeout=1000)
	public void shouldReturnALargeNumber() {
		assertEquals(1134903170, fibonacci.calculateSequence(45));
	}
	
	@Test
	public void shouldReturnASmallNumber() {
		assertEquals(3, fibonacci.calculateSequence(4));
	}
}
