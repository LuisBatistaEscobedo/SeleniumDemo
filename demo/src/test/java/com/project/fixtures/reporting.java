package com.project.fixtures;
import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reporting {

    // Report elements  created
    public static DateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest test;
    public  static ITestResult result;

    public static void reportConfiguration() throws IOException, ParseException
    {
        Calendar cal = Calendar.getInstance();
	    htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + ".src/ExtentReport/TestReport.html");
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReport);
		
		String url = data.getData("Url");
		
		// Check for the ID on Host
		InetAddress address = InetAddress.getByName(url);
		String ip = address.getHostAddress();
		
		extent.setSystemInfo("Execution Date", day.format(cal.getTime()));
		extent.setSystemInfo("Plug-In", "Maven");
		extent.setSystemInfo("IP Address", ip);
		extent.setSystemInfo("Enviroment", "Prod");
		extent.setSystemInfo("URL", data.getData("Url"));
		
		htmlReport.config().setDocumentTitle("Continous Testing");
		htmlReport.config().setReportName("Shopping Cart Report");
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReport.config().setTheme(Theme.DARK);

    }

    public static void reportFlush()
    {
        extent.flush();
    }

    public static void newLabel(String message, String color)
    {
        switch(color){
            case "GREEN":
            test.info(MarkupHelper.createLabel("Testing green", ExtentColor.GREEN));
            break;
            case "RED":
            test.info(MarkupHelper.createLabel("Testing red", ExtentColor.RED));
            break;
        }
    }

    public static void makeAssertion(String message)
    {
        Assert.assertTrue(false, message);
    }

    public static void getResults()
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    
}
