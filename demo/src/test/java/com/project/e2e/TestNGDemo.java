package com.project.e2e;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.project.fixtures.chromedriver;
import com.project.fixtures.reporting;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;


public class TestNGDemo {

    @BeforeTest
    public void preTestConfiguration () throws InterruptedException, IOException, ParseException
    {
        reporting.reportConfiguration();
        chromedriver.driverConfiguration();
    }

    @AfterMethod
    public void checkResults()
    {
        reporting.getResults();
    }

    @AfterTest
    public void tearDown() {
		reporting.reportFlush();
	}

    @Test
    public void sampleTestMethod() throws InterruptedException
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(5000);

        driver.quit();

    }

    @Test
    public void secondSampleTestMethod() throws InterruptedException
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com/");

        Thread.sleep(5000);

        driver.quit();

    }
    
}
