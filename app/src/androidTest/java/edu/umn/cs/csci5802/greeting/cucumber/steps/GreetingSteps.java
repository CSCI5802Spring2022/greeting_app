package edu.umn.cs.csci5802.greeting.cucumber.steps;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;

import edu.umn.cs.csci5802.greeting.MainActivity;
import edu.umn.cs.csci5802.greeting.R;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class GreetingSteps {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Given("^I start the application$")
    public void startApp(){
        activityTestRule.launchActivity(null);
    }

    @After
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @When("^I click the name text box$")
    public void clickNameTextBox(){
        onView(withId(R.id.name)).perform(click());
    }

    @And("^I enter (\\S+)$")
    public void typeNameTextBox(String name){
        onView(withId(R.id.name)).perform(typeText(name));
    }

    @And("^I click the display lower button$")
    public void clickDisplayLower(){
        onView(withId(R.id.displayLower)).perform(click());
    }

    @Then("^I expect to see a message with (\\S+) in lower case$")
    public void expectNameInLowerCase(String name){
        onView(withId(R.id.message)).check(matches(withText("Hello "+name.toLowerCase().trim()+"!")));
    }
}
