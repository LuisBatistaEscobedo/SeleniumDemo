package com.project.integration.mobileTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.project.fixtures.WebDriverSingleton;
import com.project.fixtures.reporting;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class MobileAndroidDemo extends BaseTest  {

    static AppiumDriver<WebElement> driver;


    @DisplayName("Case 01 - Make a search and select second element from list")
    @Test
    public void searchTest() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Redmi Note");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "S4CAEEWGV8WG4HMF");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<WebElement>(url,cap);

        System.out.println("Test started...");

        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        Thread.sleep(3000);

        // Search input validation
        driver.findElement(By.id("org.wikipedia:id/search_container")).getText().equals("Search Wikipedia");
        driver.findElement(By.id("org.wikipedia:id/search_container")).click();

        // Make a search
        driver.findElement(By.id("org.wikipedia:id/search_src_text")).sendKeys("cat");
        Thread.sleep(2000);

        // Check results are greather than 0
        List<WebElement> list = driver.findElements(By.id("org.wikipedia:id/search_results_list"));

        if(list != null){
            System.out.println("The list contains data.");
        } else {
            System.out.println("Error on results");
        }

        // Select second element from Result List
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[@index='1']")).click();
        Thread.sleep(6000);

    }


    @DisplayName("Case 02 - Make a search and validate data")
    @Test
    public void searchAndVerifyDataTest() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Redmi Note");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "S4CAEEWGV8WG4HMF");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<WebElement>(url,cap);

        System.out.println("Test started...");

        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        Thread.sleep(3000);

        // Search input validation
        driver.findElement(By.id("org.wikipedia:id/search_container")).getText().equals("Search Wikipedia");
        driver.findElement(By.id("org.wikipedia:id/search_container")).click();
        Thread.sleep(3000);

        // Make a search
        driver.findElement(By.id("org.wikipedia:id/search_src_text")).sendKeys("Hugh Laurie");
        Thread.sleep(3000);

        // Check results are greather than 0
        List<WebElement> list = driver.findElements(By.id("org.wikipedia:id/search_results_list"));

        if(list != null){
            System.out.println("The list contains data.");
        } else {
            System.out.println("Error on results");
        }

        // Select first element from Result List
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[@index='0']")).click();
        Thread.sleep(2000);

        // Open Content tab 
        driver.findElement(By.id("org.wikipedia:id/page_contents")).click();
        Thread.sleep(2000);

        // First element from content
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).getText().equals("Early life");
        Thread.sleep(1000);
        System.out.println("Early life validation");

        // Second element from content
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']")).getText().equals("Career");
        Thread.sleep(1000);
        System.out.println("Career validation");

        // Third element from content
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']")).getText().equals("Personal Life");
        Thread.sleep(1000);
        System.out.println("Personal Life validation");

        // Fourth element from content
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='4']")).getText().equals("Recognition");
        Thread.sleep(1000);
        System.out.println("Recognition validation");

        // Sixth element from content
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='5']")).getText().equals("Filmography");
        Thread.sleep(1000);
        System.out.println("Filmography validation");

        // Click on seventh element
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='5']")).click();
        Thread.sleep(3000);

    }

    @DisplayName("Case 03 - Make a search and change languages")
    @Test
    public void searchLanguagesTest() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Redmi Note");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "S4CAEEWGV8WG4HMF");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<WebElement>(url,cap);

        System.out.println("Test started...");

        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        Thread.sleep(3000);

        // Search input validation
        driver.findElement(By.id("org.wikipedia:id/search_container")).getText().equals("Search Wikipedia");
        driver.findElement(By.id("org.wikipedia:id/search_container")).click();

        // Make a search
        driver.findElement(By.id("org.wikipedia:id/search_src_text")).sendKeys("Hugh Laurie");
        Thread.sleep(3000);

        // Check results are greather than 0
        List<WebElement> list = driver.findElements(By.id("org.wikipedia:id/search_results_list"));

        if(list != null){
            System.out.println("The list contains data.");
        } else {
            System.out.println("Error on results");
        }

        // Select first element from Result List
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[@index='0']")).click();
        Thread.sleep(2000);

        // Click on Language tab
        driver.findElement(By.id("org.wikipedia:id/page_language")).click();
        Thread.sleep(5000);

        // Click on Search Language
        driver.findElement(By.id("org.wikipedia:id/menu_search_language")).click();

        // Enter Español to search text Input
        driver.findElement(By.id("org.wikipedia:id/search_src_text")).sendKeys("Español");

        // Click on first element from search language result
        driver.findElement(By.id("org.wikipedia:id/localized_language_name")).click();
        Thread.sleep(5000);

    }

    @DisplayName("Case 04 - Check the About section of the Wikipedia App")
    @Test
    public void settingsAboutTest() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Redmi Note");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "S4CAEEWGV8WG4HMF");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<WebElement>(url,cap);

        System.out.println("Test started...");

        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        Thread.sleep(3000);

        // Click on More tab
        driver.findElement(By.id("org.wikipedia:id/menu_icon")).click();
        Thread.sleep(3000);

        // Click on Settings
        driver.findElement(By.id("org.wikipedia:id/main_drawer_settings_container")).click();

        // Scroll down to bottom
        driver.findElement(MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\"About the Wikipedia app\"))"
        )).click();
        Thread.sleep(3000);

    }

    @DisplayName("Case 05 - Check the Saved articles section")
    @Test
    public void savedArticlesTest() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Redmi Note");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "S4CAEEWGV8WG4HMF");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<WebElement>(url,cap);

        System.out.println("Test started...");

        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        Thread.sleep(3000);

        // Click on Saved articles options
        driver.findElement(By.id("org.wikipedia:id/nav_tab_reading_lists")).click();
        Thread.sleep(3000);

    }

    @DisplayName("Case 06 - Make a search and Find in Article")
    @Test
    public void searchInsideArticleTest() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Redmi Note");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "S4CAEEWGV8WG4HMF");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<WebElement>(url,cap);

        System.out.println("Test started...");

        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        Thread.sleep(2000);

        // Search input validation
        driver.findElement(By.id("org.wikipedia:id/search_container")).getText().equals("Search Wikipedia");
        driver.findElement(By.id("org.wikipedia:id/search_container")).click();

        // Make a search
        driver.findElement(By.id("org.wikipedia:id/search_src_text")).sendKeys("Fusajiro Yamauchi");
        Thread.sleep(2000);

        // Check results are greather than 0
        List<WebElement> list = driver.findElements(By.id("org.wikipedia:id/search_results_list"));

        if(list != null){
            System.out.println("The list contains data.");
        } else {
            System.out.println("Error on results");
        }

        // Select first element from Result List
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[@index='0']")).click();
        Thread.sleep(1000);

        // Click on Find in article tab
        driver.findElement(By.id("org.wikipedia:id/page_find_in_article")).click();

        // Type Nintendo on Find in article input
        driver.findElement(By.id("org.wikipedia:id/search_src_text")).sendKeys("Nintendo");
        Thread.sleep(5000);

        // Click on search arrow down until third result
        driver.findElement(By.id("org.wikipedia:id/find_in_page_next")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("org.wikipedia:id/find_in_page_next")).click();
        Thread.sleep(6000);


    }

    
}
