package framework.web_pages;

import org.apache.xerces.xs.StringList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static stepdefinition.SharedSD.getDriver;

public class DarkSky2LandingPage extends framework.actions_web.BasePage {


    SharedSD sha = new SharedSD ( );

    private By emailTextField = By.id ("email");
    private By passwordTextField = By.id ("pass");
    private By loginButton = By.id ("loginbutton");
    private By firstNameTextField = By.id ("firstName");
    private By lastNameTextField = By.id ("lastName");
    private By mobileNumberTextField = By.id ("mobileNumber");
    private By newPasswordTextField = By.id ("newPwd");
    private By errorMessage = By.id ("errorMessage");
    private By timeLine = By.xpath ("//span[@class='hour']//descendant::*");
    private Calendar c;
    private String expectedhourFormat;
    private By todaysTimeline = By.xpath ("//body[@class='forecast']/div[@id='week']/a[1]");
    private By timeMachine = By.xpath ("//a[@class='button']"); ////a[@class='button']
    private By todayDate = By.xpath ("//td[@class='is-today']"); ///td[@class='is-today']
    private By verifyDate=By.xpath  ("//td[@data-day]");



    //comparing temp low and hig"
    //css selrctor
    private By low1 = By.cssSelector ("#week > a.day.revealed > span.tempRange > span.minTemp");
    private By low2 = By.cssSelector ("#week > div.dayDetails.revealed > div.summary_container > div.dayExtras > div.highLowTemp.swip > span.highTemp.swip > span.temp");
    private By high1 = By.cssSelector ("#week > a.day.revealed > span.tempRange > span.maxTemp");
    private By high2 = By.cssSelector ("#week > div.dayDetails.revealed > div.summary_container > div.dayExtras > div.highLowTemp.swip > span.lowTemp.swap > span.temp");

//    public DarkSky2LandingPage(Object driver) throws ParseException {
//        super (driver);
//    }

//    public DarkSky2LandingPage() throws ParseException {
//        super ( );
//    }

    public static void verifyTimeline() {

    }

    public void clickOnTimeLine() throws InterruptedException {
        waitFor (30000);
        SharedSD.getDriver ( ).findElement (todaysTimeline).click ( );
    }

    public String getLow1() {
        System.out.println (getText (low1));
        return getText (low1);

    }

    public String getLow2() {
        return getText (low2);
    }

    public void verifyTemp() {
        String verifyLow1 = getLow1 ( );
        String verifyLow2 = getLow2 ( );
        Assert.assertEquals (verifyLow1, verifyLow2);
    }

    public String getHigh1() {
        return getText (high1);

    }

    public String getHigh2() {
        return getText (high2);
    }

    public void verifyTemp1() {
        String verifyHigh1 = getHigh1 ( );
        String verifyHigh2 = getHigh2 ( );
        Assert.assertTrue (verifyHigh1 == verifyHigh2);
    }

    public String getTodayDate ()
    {
        return getText (todayDate );
    }
    public void enterEmail(String enterEmail) {
        sendText (emailTextField, enterEmail);
    }

    public void enterPassword(String enterPassword) {
        sendText (passwordTextField, enterPassword);
    }

    public void enterFirstName(String firstName) {
        sendText (firstNameTextField, firstName);
    }

    public void enterLastName(String lastName) {
        sendText (lastNameTextField, lastName);
    }

    public void enterMobileNumber(String mobileNum) {
        sendText (mobileNumberTextField, mobileNum);
    }

    public void enterNewPassword(String password) {
        sendText (newPasswordTextField, password);
    }




    public void getListItem1() {
        List<WebElement> timeLineElements = SharedSD.getDriver ( ).findElements (timeLine);

        List<String> allElementsText = new ArrayList<> ( );
        for (WebElement timelineElement : timeLineElements) {
            String timelineHours = timelineElement.getText ( );
            allElementsText.add (timelineHours);
        }
        System.out.println (allElementsText);
        SimpleDateFormat sdf = new SimpleDateFormat ("ha");

        List<String> hourList = new ArrayList<> ( );
        for (int i = 2; i < 24; i += 2) {
            Calendar c = Calendar.getInstance ();
            c.add (Calendar.HOUR, i);
            Date hour = c.getTime ( );
            String expectedHourFormat;
            expectedHourFormat = sdf.format (hour).toLowerCase ();
            hourList.add (expectedHourFormat);
        }
        System.out.println (hourList);
        Assert.assertEquals (allElementsText, hourList);


    }

   // public void chooseTomorrowDate() {
    //}


    public void clickOnTimeMachine() throws InterruptedException {
        waitFor (3000);
        scrollOnThePage ( );
        clickOn (timeMachine);
        // SharedSD.getDriver ( ).findElement (timeMachine).click ( );
        //System.out.println ("The day is " +getDate ());
        //System.out.println ("The element value is " +todayDate);

    }

// this will be used for Assertion (whatIsTodaysDate(),and element)

    public String whatIsTodaysDate() throws InterruptedException {
        Date date = new Date ( );
        SimpleDateFormat sdf = new SimpleDateFormat ("d");
        Calendar c = Calendar.getInstance ( );
        Date expectedDay = c.getTime ( );
        String expectedDayFormat = sdf.format (expectedDay);

        return expectedDayFormat;

        }
    }
























