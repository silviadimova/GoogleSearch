package com.search.stepDefinitions;

import com.search.robots.GoogleSearchRobot;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchStep {

    private GoogleSearchRobot robot = new GoogleSearchRobot();

    @After
    public void tearDown() {
        robot.closeBrowser();
    }

    @Given("^As a user on Google Search page$")
    public void asAUserOnGoogleSearchPage() {
        robot.loadGooglePage();
    }

    @When("^I perform search about Cars in London$")
    public void iPerformSearchAboutCarsInLondon() {
        robot.performSearchWithText("Cars in London");
    }

    @And("^I verify the number of all Gumtree links found$")
    public void iVerifyTheNumberOfAllGumtreeLinksFound() {
        robot.checkGumtreeLinksNumber();
    }

    @Then("^I select only Gumtree links and see their title and results$")
    public void iSelectOnlyGumtreeLinks() {
        robot.selectAllGumtreeLinksAndVerifyTitlesAndResults();
    }

}
