package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.DarkSky2LandingPage;
import org.testng.Assert;

import java.text.ParseException;


public class DarkSkySD {


    DarkSky2LandingPage darksky2HomePage = new DarkSky2LandingPage ( );

    public DarkSkySD() throws ParseException {
    }

     /// add test
    @Given("^I am on Darksky home page$")
    public void siAmOnHomePage() {
        //Assert.assertEquals (SharedSD.getDriver ().getTitle (), "Dark Sky");
    }


    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline() throws InterruptedException {
        darksky2HomePage.getListItem1 ( );
    }

    // DarkSky senario #2
    @When("^I expand todays timeline$")
    public void clickOnTodaysTimeline() {darksky2HomePage.clickOnTimeLine ();
    }
    @Then ("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLoweAndHigh(){}

}





