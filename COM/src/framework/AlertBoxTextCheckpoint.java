package framework;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class AlertBoxTextCheckpoint {
	public void alertBoxTextCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,String DriverToInvoke, String TakeScreenshot,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles,ExtentTest test) throws IOException, ParseException, InterruptedException
	{

		
		String Status=null;		
		System.out.println(driver.switchTo().alert().getText());
		
		
		if(driver.switchTo().alert().getText().equals(testData))
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--PASS");

			Status = "Pass";

			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
					application, driver, test, TakeScreenshot);
			// extent report for status pass
			//test.pass(testCaseno + " " + testCaseDescription);
		}
		else
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--FAIL");
			Status = "Fail";

			try {
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
						application, driver, test, TakeScreenshot);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription);
		}
		
	}
	
	
	public void alertBoxTextCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue, int j,String DriverToInvoke, String TakeScreenshot,
			String report, String application,String startTm,String endTm,Set<String> windowhandles,ExtentTest test) throws IOException, ParseException, InterruptedException
	{
		
		
		String Status=null;
		System.out.println(driver.switchTo().alert().getText());
		
		
		if(driver.switchTo().alert().getText().equals(testData))
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--PASS");

			Status = "Pass";

			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
					application, driver, test, TakeScreenshot);

			// extent report for status pass
			//test.pass(testCaseno + " " + testCaseDescription);
		}
		else
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--FAIL");
			Status = "Fail";

			try {
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
						application, driver, test, TakeScreenshot);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// extent report for status fail
			//test.fail(testCaseno + " " + testCaseDescription);
		}
		
	}	
	
	
}
