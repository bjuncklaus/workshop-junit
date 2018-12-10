package br.com.workshop.fixtures;

import static org.junit.Assert.assertEquals;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFixturesExample {
	static class ExpensiveManagedResource implements Closeable {
		public void close() throws IOException {}
	}

	static class ManagedResource implements Closeable {
		public void close() throws IOException {}
	}
	
	
	
	
	private ManagedResource myManagedResource;
	private static ExpensiveManagedResource myExpensiveManagedResource;
	
	private static Random random;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("@BeforeClass setUpClass");
		myExpensiveManagedResource = new ExpensiveManagedResource();
		random = new Random(42);
	}

	@AfterClass
	public static void tearDownClass() throws IOException {
		System.out.println("@AfterClass tearDownClass");
		myExpensiveManagedResource.close();
		myExpensiveManagedResource = null;
	}

	@Before
	public void setUp() {
		this.println("@Before setUp");
		this.myManagedResource = new ManagedResource();
	}

	@After
	public void tearDown() throws IOException {
		this.println("@After tearDown");
		this.myManagedResource.close();
		this.myManagedResource = null;
	}

	@Test
	public void test1() {
		this.println("@Test test1()");
	}

	@Test
	public void test2() {
		this.println("@Test test2()");
	}
	
	@Test
	public void testRandomSeed() {
		assertEquals(-1170105035, random.nextInt());
	}
	
	private void println(String string) {
		System.out.println(string);
	}
}
