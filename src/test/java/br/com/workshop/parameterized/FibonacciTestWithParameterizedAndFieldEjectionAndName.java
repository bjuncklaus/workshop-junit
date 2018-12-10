package br.com.workshop.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.workshop.code.Fibonacci;

@RunWith(Parameterized.class)
public class FibonacciTestWithParameterizedAndFieldEjectionAndName {

    private static Fibonacci fibonacci;
    
    @Parameter // aqui tem um (0) como default
    public int input; // tem que ser public se não o JUnit não consegue acessar
    
    @Parameter(1) // aqui tem que especificar
    public int expected; // tem que ser public se não o JUnit não consegue acessar

    @Parameters(name = "{index}: teste({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }  
           });
    }
    
    @BeforeClass
    public static void setUpClass() {
    	fibonacci = new Fibonacci();
    }

    @Test
    public void test() {
        assertEquals(expected, fibonacci.calculateSequence(input));
    }
}