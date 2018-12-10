package br.com.workshop.categories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import br.com.workshop.code.PrimeFactor;
import br.com.workshop.interfaces.FastTests;
import br.com.workshop.interfaces.SlowTests;

public class PrimeFactorTest {

	private PrimeFactor primeFactor;
	
	@Before
	public void setUp() {
		primeFactor = new PrimeFactor();
	}
	
	@Category(FastTests.class)
	@Test
	public void shouldFindTheLargestPrimeFactorOfALongValue() {
		assertEquals(649657, primeFactor.largestPrimeFactor(Long.MAX_VALUE));
	}
	
	@Test
	public void shouldReturn5() {
		assertEquals(5, primeFactor.largestPrimeFactor(10));
	}
	
	@Category(SlowTests.class)
	@Test
	public void shouldHave974Factors() {
		List<Integer> primeFactors = primeFactor.primeFactors(Double.MAX_VALUE);
		assertEquals(974, primeFactors.size());
	}
	
}
