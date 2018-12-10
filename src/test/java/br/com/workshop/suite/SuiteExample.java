package br.com.workshop.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.workshop.annotations.AnnotationsTest;
import br.com.workshop.assertions.AssertTests;

@RunWith(Suite.class)
@SuiteClasses({AssertTests.class, AnnotationsTest.class})
public class SuiteExample {
	// the class remains empty,
	// used only as a holder for the above annotations
}
