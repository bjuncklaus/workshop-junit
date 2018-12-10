package br.com.workshop.timeout;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.Timeout;

import br.com.workshop.code.PrimeFactor;
import br.com.workshop.interfaces.FastTests;
import br.com.workshop.interfaces.SlowTests;

public class PrimeFactorWithTimeOutRuleTest {

	private PrimeFactor primeFactor;
	
	@Rule
    public Timeout globalTimeout = new Timeout(100);

	
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
