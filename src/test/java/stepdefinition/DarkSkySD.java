package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.actions_web.BasePage;
import framework.web_pages.DarkSky2LandingPage;
import org.testng.Assert;

import java.text.ParseException;


public class DarkSkySD  {


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
        darksky2HomePage.getListItem1 ();

    }

    // DarkSky senario #2
    @When("^I expand todays timeline$")
    public void clickOnTodaysTimeline() throws InterruptedException {
        darksky2HomePage.clickOnTimeLine ( );
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLoweAndHigh() {
    }



    // DarkSky senario #3
   @When ("^I click on Time Machine$")
   public void clickTimeMachine()throws InterruptedException {
       darksky2HomePage.clickOnTimeMachine ( );
   }
   @Then ("^I verify date is selected to todays date$")
      public void verifyDateSelected()throws InterruptedException{
       Assert.assertEquals(darksky2HomePage.whatIsTodaysDate (),darksky2HomePage.getTodayDate());
       }
   }










