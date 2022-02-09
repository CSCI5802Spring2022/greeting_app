package edu.umn.cs.csci5802.greeting.tests;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features={"features"}, glue={"edu.umn.cs.csci5802.greeting.cucumber.steps"})
public class CucumberTestCase {

}
