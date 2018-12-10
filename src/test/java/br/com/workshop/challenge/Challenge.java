package br.com.workshop.challenge;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import br.com.workshop.interfaces.FastTests;

@FixMethodOrder(MethodSorters.JVM)
public class Challenge {

	private List<String> items = new ArrayList<String>();
	
	@Before
	public void setUp() {
		items.add("item 1");
	}
	
	@Category(FastTests.class)
	@Test
	public void shouldHaveOnlyOneElement() {
		assertThat(items.size(), is(1));
	}
	
	@Category(FastTests.class)
	@Test
	public void shouldHaveTwoElements() {
		items.add("item2");
		assertThat(items.size(), is(2));
	}
}
