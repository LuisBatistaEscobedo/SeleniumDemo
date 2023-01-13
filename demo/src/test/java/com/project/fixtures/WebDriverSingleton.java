package com.project.fixtures;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSingleton {

    public static WebDriver driver = null;
    public static WebDriverWait wait;
    static AppiumDriver<WebElement> mobiledriver;

    public static WebDriver getInstance(){

        if(driver == null){
            chromedriver.driverConfiguration();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static WebDriver killInstance()
    {
        driver = null;
        return driver;
    }

    public static void setCapabilities() throws MalformedURLException{
        
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Pixel 4");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        wait = new WebDriverWait(driver, 10);
    }
    
}
