package com.project.pagesAndActions.common.pages.web;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.project.fixtures.WebDriverSingleton;

public class commonPage{

    public static WebDriver driver = WebDriverSingleton.getInstance();
    //public static WebDriverWait wait;

    /********************************************************/
    /******************** Locators **************************/
    /********************************************************/
    
    private static String username = "//div[@class='form_group']/input[@data-test='username']";
    private static String password = "//div[@class='form_group']/input[@data-test='password']";
    private static String loginButton = "//form/input[@data-test='login-button']";
    private static String nameItem = "//div[@class='inventory_item']//a/div[@class='inventory_item_name']";
    
    /******************** End Locators **********************/

    

    /********************************************************/
    /******************** Interactions **********************/
    /********************************************************/
 
    public static void userName(String data)
    {
        driver.findElement(By.xpath(username)).sendKeys(data);
    }
    
    public static void userPassword(String data)
    {
        driver.findElement(By.xpath(password)).sendKeys(data);
    }

    public static void clickLoginButton()
    {
        driver.findElement(By.xpath(loginButton)).click();
    }

    public static void clickOnTitleElement(String name){
        driver.findElement(By.xpath(nameItem+"[text()='"+ name +"']")).click();
    }

    public static void waitUntilClickableXpath(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public static void waitUntilClickableId(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
    }

    public static void waitTime(Integer timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }


}
