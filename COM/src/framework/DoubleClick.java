package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DoubleClick {
	
	public static Set<String>  doubleClick(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	
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
			// this is to double click on the webelement
			
			Actions click_action = new Actions(driver);
			click_action.moveToElement(webelement).doubleClick().build().perform();
			
			Thread.sleep(3000);
			
			if (!viewPort.toUpperCase().equals("APPIUM"))
			{
			windowhandles=driver.getWindowHandles();
			}
			
						System.out.println(testCaseno+" "+testCaseDescription);

			

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
         	}
			
         //this is catch statement
		} 
		catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
			}
		}
		return windowhandles;
	}
	
	@SuppressWarnings("rawtypes")
	public void doubleClick(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	
			{
		String Status = null;
		try {
			Thread.sleep(1000);
			
			// this is to double click on the webelement
			
			Actions click_action = new Actions(driver);
			click_action.moveToElement(element).doubleClick().build().perform();
			
			Thread.sleep(3000);
			
			if (!viewPort.toUpperCase().equals("APPIUM"))
			{
			windowhandles=driver.getWindowHandles();
			}
			
			
			System.out.println(testCaseno+" "+testCaseDescription);

		
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
         	}
			
         //this is catch statement
		} 
		catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR" +e.getMessage());

		
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
			}
		}
	}

}
