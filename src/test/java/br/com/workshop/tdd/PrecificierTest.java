package br.com.workshop.tdd;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.workshop.code.Precifier;

public class PrecificierTest {

	private Precifier precifier;
	
	@Before
	public void setUp() {
		precifier = new Precifier();
	}
	
	@Test
	public void shouldGiveTenPercentDiscount() {
		precifier.setValue(50f);
		precifier.giveTenPercentDiscount();
		assertTrue(precifier.getValue() == 45f);
	}
	
	@Test
	public void shouldNotGiveTenPercentDiscount() {
		precifier.setValue(0f);
		precifier.giveTenPercentDiscount();
		assertThat(precifier.getValue(), is(0f));
	}

}
