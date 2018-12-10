package br.com.workshop.suite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.workshop.categories.FibonacciTest;
import br.com.workshop.categories.PrimeFactorTest;
import br.com.workshop.interfaces.SlowTests;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@SuiteClasses({FibonacciTest.class, PrimeFactorTest.class})
public class SlowTestSuite {
}
