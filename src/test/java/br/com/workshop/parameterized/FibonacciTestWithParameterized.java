package br.com.workshop.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.workshop.code.Fibonacci;

@RunWith(Parameterized.class)
public class FibonacciTestWithParameterized {

    private static Fibonacci fibonacci;
    private int input;
    private int expected;
    
    @Parameters
    public static Collection<Object[]> data() { // O nome do método não é opcional
    	return Arrays.asList(new Object[][] {     
    		{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
    	});
    }
    
    @BeforeClass
    public static void setUpClass() {
    	fibonacci = new Fibonacci();
    }

    // Cada instância da fixture é construída com o construtor com dois argumentos e seus valores são declarados no método com @Parameters
    public FibonacciTestWithParameterized(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testCalculateSequence() {
        assertEquals(expected, fibonacci.calculateSequence(input));
    }
}