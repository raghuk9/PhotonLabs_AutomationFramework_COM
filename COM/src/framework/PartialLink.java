package framework;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class PartialLink{
	
	public static Set<String>  click(String viewPort, String functionality,
									 String driverExecute, String testCaseno,
									 String testCaseDescription, String testCaseExecute,
									 WebElement webelement, String testData, String action,
									 WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
									 String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	
			{
		String Status = null;
		String Windowid=null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
			 Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				System.out.println(driver.getWindowHandle());
			}
			// this is to click on the webelement
			
			webelement.findElement(By.partialLinkText(testData)).click();
			Thread.sleep(3000);
			
			if (!viewPort.toUpperCase().equals("APPIUM"))
			{
			windowhandles=driver.getWindowHandles();
			}
			
			
			System.out.println(testCaseno+" "+testCaseDescription);

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

         	}
			
         //this is catch statement
		} 
		catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		}
		return windowhandles;
	}

	public static Set<String>  click(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	
			{
		System.out.println("Mobile click");
		String Status = null;
		String Windowid=null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
			 Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				System.out.println(driver.getWindowHandle());
			}
			// this is to tap on the mobilelement

			//element.tap(1,1);
			element.click();
			Thread.sleep(3000);
			
			if (!viewPort.toUpperCase().equals("APPIUM"))
			{
			windowhandles=driver.getWindowHandles();
			}
			
			
			System.out.println(testCaseno+" "+testCaseDescription);

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

         	}
			
         //this is catch statement
		} 
		catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		}
		return windowhandles;
	}


}
