package framework;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class BackButton {

	// This is to click on the back button
	public void backButton(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws InterruptedException {
		if (!DriverToInvoke.equals("safari")) {
			((JavascriptExecutor) driver).executeScript("javascript: setTimeout(\"history.go(-1)\", 2000)");
		} else {
			System.out.println("Navigating to Back--Pass");
		}
		try {
			Thread.sleep(2000);
			driver.navigate().back();
			System.out.println("Navigating to Back--Pass");

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription + " Navigated Back");

		} catch (Exception e) {
			System.out.println("Navigating to Back--ERROR");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void backButton(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	
			{
		String Status = null;
		try {
			System.out.println("Device Back Button Click");
			((AndroidDriver)driver).pressKeyCode(4);
			Thread.sleep(3000);
			
			System.out.println(testCaseno+" "+testCaseDescription);

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

         	}			
		} 
		catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");

			
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
			
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);


			}
		}		
	}

}
