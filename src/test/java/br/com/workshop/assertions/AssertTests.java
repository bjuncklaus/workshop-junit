package br.com.workshop.assertions;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Ignore;
import org.junit.Test;

public class AssertTests {
	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		assertArrayEquals("failure - byte arrays are not the same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		String expectedText = "text";
		String actualText = "text";
		assertEquals("failure - strings are not equal", expectedText, actualText);
	}

	@Test
	public void testAssertFalse() {
		boolean thisWorkshopIsBoring = false;
		assertFalse("failure - should be false", thisWorkshopIsBoring);
	}
	
	@Test
	public void testAssertTrue() {
		assertTrue("failure - should be true", true);
	}

	@Test
	public void testAssertNotNull() {
		Object object = new Object();
		assertNotNull("should not be null", object);
//		Object object = null;
//		assertNotNull("should not be null", object);
//		assertNotNull(object);
	}

	@Test
	public void testAssertNotSame() {
		assertNotSame("should not be same Object", new Object(), new Object());
	}

	@Test
	public void testAssertNull() {
		assertNull("should be null", null);
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(1);
		assertSame("should be same", aNumber, aNumber);
	}

	// JUnit Matchers assertThat. Expected and Actual are reversed!
	// Documentation: http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/CoreMatchers.html
	@Test
	public void testAssertThatHasItems() {
		assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	}
	
	// FIXME
	@Test
	public void testAssertThatBothContainsString() {
		String assertedValue = "abacate";
		assertThat("value should contain a and b", assertedValue, both(containsString("a")).and(containsString("b")));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	}

	// FIXME
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		assertThat("good", allOf(equalTo("good"), startsWith("go")));
		assertThat("good", not(allOf(equalTo("good"), equalTo("god"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		assertThat(new Object(), not(sameInstance(new Object())));
	}
}
