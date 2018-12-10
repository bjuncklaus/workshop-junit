package br.com.workshop.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.workshop.annotations.AnnotationsTest;
import br.com.workshop.assertions.AssertTests;
import br.com.workshop.categories.FibonacciTest;
import br.com.workshop.categories.PrimeFactorTest;

public class TestRunnerExample {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AssertTests.class, AnnotationsTest.class, FibonacciTest.class, PrimeFactorTest.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println();
		System.out.println(result.getRunCount() + " testes foram executados.");
		System.out.println("Testes foram bem sucedidos: " + result.wasSuccessful());
	}

}
