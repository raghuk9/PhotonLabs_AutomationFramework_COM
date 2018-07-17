package framework;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ComparingOldValue {
	public void comparingOldValue(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws InterruptedException,
			IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			Thread.sleep(4000);
			String NewValue = webelement.getText();
			System.out.println(NewValue);
			String value = oldValue;
			String TestDatavalue = testData;
			Float ActualNewValue = Float.parseFloat(NewValue);
			Float ActualoldValue = Float.parseFloat(value);
			Float ActualTestData = Float.parseFloat(TestDatavalue);
			
		
			if ((ActualoldValue + ActualTestData) == ActualNewValue) {
				System.out.println("Data is changed/added");

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				}
			}

			else {
				System.out.println("Data is not changed/added");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				}
			}
		} catch (Exception e) {

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		}
	}
	
	public void comparingOldValue(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws InterruptedException,
			IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			Thread.sleep(4000);
			String NewValue = element.getText();
			System.out.println("text from app is...."+NewValue);
			String value = oldValue;
			System.out.println("text from sheet is...."+oldValue);
			String TestDatavalue = testData;
			Float ActualNewValue = Float.parseFloat(NewValue);
			Float ActualoldValue = Float.parseFloat(value);
			Float ActualTestData = Float.parseFloat(TestDatavalue);
			
		
			if ((ActualoldValue + ActualTestData) == ActualNewValue) {
				System.out.println("Data is changed/added");

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
				}
			}

			else {
				System.out.println("Data is not changed/added");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
				}
			}
		} catch (Exception e) {

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
			}
		}
	}	
}
