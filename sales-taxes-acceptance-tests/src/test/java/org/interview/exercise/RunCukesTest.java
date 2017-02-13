package org.interview.exercise;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

/**
 * Created by mmingoli on 2/13/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html"},
        glue = {"org.interview.exercise.stepdefs"},
        features = "src/test/resources/features")
public class RunCukesTest {

    @Test
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }

}