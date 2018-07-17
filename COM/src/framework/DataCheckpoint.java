package framework;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class DataCheckpoint {
	public void dataCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot,int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws InterruptedException,
			IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			Thread.sleep(2000);
			if (webelement.getText().equals(testData)) {
				System.out.println(testCaseDescription
						+ " Displaying correctly as " + webelement.getText());
				
					Status = "Pass";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);
				
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as " + webelement.getText());
				
					Status = "Fail";
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);
				
			}
		} catch (Exception e) {
			
				Status = "Fail";
				System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
			
		}

	}
	
	public void dataCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws InterruptedException,
			IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			Thread.sleep(2000);
			if (element.getText().equals(testData)) {
				System.out.println(testCaseDescription
						+ " Displaying correctly as " + element.getText());
				
					Status = "Pass";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);
				
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as " + element.getText());
				
					Status = "Fail";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);
				
			}
		} catch (Exception e) {
			
				Status = "Fail";
				System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
			
		}
	}
	
}
