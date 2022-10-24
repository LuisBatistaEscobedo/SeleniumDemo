package com.project.fixtures;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class screenshot {

    //Screenshot folder created
	static Calendar cal = Calendar.getInstance();
	static File directory = new File(System.getProperty("user.dir") + ".src/ExtentReport/Screenshots");
	static String fileDirectory = directory.toString();
	static ExtentTest test;
	Properties properties;

    public static void captureScreenshot(WebDriver driver, String name) throws IOException {
		
		if(!directory.exists()){
			directory.mkdir();
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = fileDirectory + "\\" + name + ".png";
        FileUtils.copyFile(scrFile, new File(path));
        test.pass("Screenshot below: ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        
	}
    
}
