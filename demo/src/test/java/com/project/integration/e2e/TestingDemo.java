package com.project.integration.e2e;
import org.openqa.selenium.WebDriver;
import com.project.fixtures.WebDriverSingleton;
import com.project.fixtures.data;
import com.project.fixtures.reporting;
import com.project.pagesAndActions.common.actions.commonActions;
import com.project.pagesAndActions.common.pages.commonPage;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseTest
{
    public WebDriver driver;

    @BeforeEach
    public void setup()
    {
        driver = WebDriverSingleton.getInstance();
    }

    @AfterEach
    public void teardown()
    {
        driver.quit();
        driver = WebDriverSingleton.killInstance();
    }

    @BeforeAll
    public static void buildUp() throws IOException, ParseException
    {
        reporting.reportConfiguration();
    }

    @AfterAll
    public static void tearDown() {
        reporting.reportFlush();
	}
}

public class TestingDemo extends BaseTest {

    @DisplayName("Landing Page Test")
    @Test
    public void landingPageTest() throws InterruptedException, IOException, ParseException
    {
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Naming the test on the Report
        reporting.initializeTest("Simple Test on landing page");

        
        // Opening driver instance with first site URL
        driver.get(data.getData("LandingPage"));
        Thread.sleep(2000);

        reporting.messagePassLog("Simple landing page for " + data.getData("LandingPage"));
        reporting.takesScreenshot(driver, "LandingPageScreen","Landing page screen from site");
        reporting.messagePassLog("No additional actions needed for this test");
        Thread.sleep(1000);

    }

    
    @DisplayName("Landing Page Test - Failing")
    @Test 
    public void landingPageTestNegative() throws InterruptedException, IOException, ParseException
    {
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Naming the test on the Report
        reporting.initializeTest("Negative Test");

        // Opening driver instance with first site URL
        driver.get(data.getData("LandingPage"));
        Thread.sleep(2000);

        reporting.messagePassLog("Simple landing page for " + data.getData("LandingPage"));
        reporting.takesScreenshot(driver, "LandingPageScreen","Landing page screen from site");
        reporting.messageFailLog("In this step, we should say the test is failing.");
        reporting.messagePassLog("For instance, the whole test should be showing as failing on the report.");
        reporting.takesScreenshot(driver, "SecondScreen","Failed test Screenshot");

        Thread.sleep(1000);

    }

    @DisplayName("Testing")
    @Test 
    public void actionsExample() throws InterruptedException, IOException, ParseException
    {
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Naming the test on the Report
        reporting.initializeTest("Login Test");

        // Opening driver instance with first site URL
        driver.get(data.getData("LoginSite"));
        Thread.sleep(2000);

        reporting.messagePassLog("Testing Login Site");
        reporting.takesScreenshot(driver, "InputPageScreen","Landing page screen from site");
        Thread.sleep(5000);

        // Fill form with user data
        commonPage.userName("standard_user");
        commonPage.userPassword("secret_sauce");
        reporting.messagePassLog("Succesfully fill the Form.");
        Thread.sleep(1000);
        reporting.takesScreenshot(driver, "FillData","Filled form for Login page");

        // Login User
        commonPage.clickLoginButton();

        Thread.sleep(1000);
        reporting.takesScreenshot(driver, "HomePage","Home page screenshoot from Store.");

        // Scroll to Bottom page
        commonActions.scrollToBottom();
        Thread.sleep(2000);
        reporting.messagePassLog("Scroll to bottom.");
        reporting.takesScreenshot(driver, "BottomPage","Bottom page from store");

        // Click on element
        commonPage.clickOnTitleElement("Sauce Labs Fleece Jacket");
        Thread.sleep(2000);
        reporting.messagePassLog("Item opened from the store.");
        reporting.takesScreenshot(driver, "ItemPage","'Sauce Labs Fleece Jacket' details from store");

    }
    
}
