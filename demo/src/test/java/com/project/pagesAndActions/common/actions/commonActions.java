package com.project.pagesAndActions.common.actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.project.fixtures.WebDriverSingleton;

public class commonActions {
    
    public static WebDriver driver = WebDriverSingleton.getInstance();
    public Actions action = new Actions(driver);
    public static JavascriptExecutor js = (JavascriptExecutor) driver;

/********************************************************/
/******************** Interactions **********************/
/********************************************************/

public static void scrollToBottom(){

    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

}


/******************** End Interactions ******************/

/********************************************************/
/********************* Validations **********************/
/********************************************************/




/********************* End Validations *******************/
    
}
