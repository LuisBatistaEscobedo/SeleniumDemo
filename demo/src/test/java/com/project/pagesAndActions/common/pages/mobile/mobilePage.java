package com.project.pagesAndActions.common.pages.mobile;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.project.fixtures.WebDriverSingleton;

public class mobilePage {

    public static WebDriver driver = WebDriverSingleton.getInstance();
    
    /********************************************************/
    /******************** Locators **************************/
    /********************************************************/
    
    private static String skippButton = "org.wikipedia:id/fragment_onboarding_skip_button";
    private static String searchInput = "org.wikipedia:id/search_container";
    private static String searchToolbar = "org.wikipedia:id/search_src_text";
    private static String searchResults = "org.wikipedia:id/search_results_list";
    
    /******************** End Locators **********************/

    /********************************************************/
    /******************** Interactions **********************/
    /********************************************************/

    public static void waitUntilClickableId(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
    }

    public static void waitTime(Integer timeout){
        driver.manage()
                .timeouts()
                .implicitlyWait(timeout, TimeUnit.SECONDS);
    }
    


    /****************** End Interactions ********************/

    /********************************************************/
    /********************** AppActions **********************/
    /********************************************************/

    public static void accessApp(){

        waitUntilClickableId(skippButton);
        driver.findElement(By.id(skippButton))
                .click();
        waitTime(2);
        
    }

    public static void searchInWiki(String value){
        waitUntilClickableId(searchInput);
        driver.findElement(By.id(searchInput))
                .getText()
                .equals("Search Wikipedia");
        driver.findElement(By.id(searchInput))
                .click();
        waitUntilClickableId(searchToolbar);
        driver.findElement(By.id(searchInput))
                .sendKeys(value);
        waitTime(3);
    }

    public static void resultValidation(){

        List<WebElement> list = driver.findElements(By.id(searchResults));

        if(list != null){
            System.out.println("The list contains data.");
        } else {
            System.out.println("Error on results");
        }

        // Select second element from Result List
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[@index='1']")).click();

    }

    /******************** EndAppActions *********************/

}
