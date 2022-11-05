package com.project.e2e;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.project.fixtures.chromedriver;
import com.project.fixtures.data;
import com.project.fixtures.reporting;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestNGDemo {

    @BeforeAll
    public static void buildUp() throws IOException, ParseException
    {
        reporting.reportConfiguration();
    }

    @BeforeEach
    public void preTestConfiguration () throws InterruptedException, IOException, ParseException
    {
        chromedriver.driverConfiguration();
        
    }

    @AfterAll
    public static void tearDown() {
        reporting.reportFlush();
	}

    @DisplayName("Google Test")
    @Test
    public void sampleTestMethod() throws InterruptedException, IOException, ParseException
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(data.getData("Url"));

        reporting.initializeTest("Test name by classes");
        reporting.messagePassLog("This is the first message Log");
        reporting.messagePassLog("This is the second message Log");
        reporting.messagePassLog("This is the fourth message Log");
        reporting.messageFailLog("This is the fourth message and is failing");
        reporting.takesScreenshot(driver, "TestingScreen");

        
        Thread.sleep(1000);
       

        driver.quit();

    }

    
    @DisplayName("Automation Practice Test")
    @Test 
    public void secondSampleTestMethod() throws InterruptedException, IOException
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/");

        Thread.sleep(1000);

        reporting.initializeTest("Second test name by classes");
        reporting.takesScreenshot(driver, "TestingfourScreen");
        reporting.messageFailLog("This is the fourth message and is failing");
        reporting.messagePassLog("This is the second message Log");
        reporting.messagePassLog("This is the fourth message Log");

        driver.quit();

    }
    
}
