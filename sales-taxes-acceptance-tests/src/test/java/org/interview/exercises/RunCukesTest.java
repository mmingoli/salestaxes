package org.interview.exercises;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by mmingoli on 2/13/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html"},
        glue = {"org.interview.exercises.stepdefs"},
        features = "src/test/resources/features")
public class RunCukesTest {

    @Test
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }

}