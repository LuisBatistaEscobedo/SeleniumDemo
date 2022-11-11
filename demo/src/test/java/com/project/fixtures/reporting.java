package com.project.fixtures;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reporting {

    // Report elements  created
    public static DateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	public static ExtentTest test;
	public static ExtentReports extent = new ExtentReports();
    public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("src/test/java/com/project/fixtures/ExtentReport/TestReport.html");
    public static Calendar cal = Calendar.getInstance();
	public static File directory = new File(System.getProperty("user.dir") + "/src/test/java/com/project/fixtures/ExtentReport/Screenshots");
	public static String fileDirectory = directory.toString();

    public static void reportConfiguration() throws IOException, ParseException
    {
        Calendar cal = Calendar.getInstance();
		
		extent.setSystemInfo("Execution Date", day.format(cal.getTime()));
		extent.setSystemInfo("Plug-In", "Maven");
		extent.setSystemInfo("Enviroment", "Prod");
		extent.setSystemInfo("URL", data.getData("Url"));
		
		reporter.config().setDocumentTitle("Selenium Demo");
		reporter.config().setReportName("Selenium Demo");
		reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		reporter.config().setTheme(Theme.DARK);

        extent.attachReporter(reporter);

    }

    public static void reportFlush()
    {
        extent.flush();
    }

    public static void initializeTest(String testName)
    {
        extent.attachReporter(reporter);
        test = extent.createTest(testName);
    }

    public static void messagePassLog(String message)
    {
        test.log(Status.PASS, message);
    }

    public static void messageFailLog(String message)
    {
        test.log(Status.FAIL, message);
    }

    public static void takesScreenshot(WebDriver driver, String name, String screenshotMessage) throws IOException
    {
        if(!directory.exists()){
			directory.mkdir();
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = fileDirectory + "\\" + name + ".png";
        FileUtils.copyFile(scrFile, new File(path));
        test.pass(screenshotMessage, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    
}
