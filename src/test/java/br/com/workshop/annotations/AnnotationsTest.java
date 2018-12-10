package br.com.workshop.annotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationsTest {
	static int beforeClassCount = 0;
	static int beforeCount = 0;
	static int afterClassCount = 0;
	static int afterCount = 0;
	
	@BeforeClass
	public static void setUpClass() {
		beforeClassCount++;
		System.out.println("Passou no @BeforeClass: " + beforeClassCount);
	}
	
	@Before
	public void setUp() {
		beforeCount++;
		System.out.println("Sou tagarela. Passou no @Before: " + beforeCount);
	}
	
	@After
	public void tearDown() {
		afterCount++;
		System.out.println("Também gosto de aparecer. Passou no @After: " + afterCount);
	}
	
	@AfterClass
	public static void tearDownClass() {
		afterClassCount++;
		System.out.println("Passou no @AfterClass: " + afterClassCount);
	}
	
	@Test
	public void beforeCountShouldNotBeZero() {
		assertThat(beforeCount, not(equalTo(0)));
	}
	
	@Test
	public void afterCountShouldBeZeroOrGreater() {
		assertThat(afterCount, greaterThanOrEqualTo(0));
	}
	
	@Test
	public void afterClassCountShouldBeZero() {
		assertThat(afterClassCount, equalTo(123));
//		assertEquals("abc", "fjf");
	}
	
	@Test
	public void beforeClassCountShouldBeOne() {
		assertThat(beforeClassCount, equalTo(1));
	}
	
	
}
