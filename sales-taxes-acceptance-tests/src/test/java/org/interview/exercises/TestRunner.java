package org.interview.exercises;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mmingoli on 2/12/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "src/test/resources/org/interview/exercises",
        glue = {"org.interview.exercises.stepdefs"})
public class TestRunner {
}
