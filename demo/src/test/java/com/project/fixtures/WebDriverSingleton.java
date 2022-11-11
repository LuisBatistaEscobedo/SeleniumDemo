package com.project.fixtures;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSingleton {

    public static WebDriver driver = null;

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
    
}
