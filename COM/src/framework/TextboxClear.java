package framework;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class TextboxClear {

	public static void textboxClear(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException {

		String Status = null;
		try {

			if (viewPort.toUpperCase().equals("DESKTOP")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				// windowhandles.add(Windowid);
			}

			Thread.sleep(2000);

			webelement.clear();

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

		} catch (Exception e) {
			System.out.println("Error occured while clearing the data");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription + " ERROR: -- " + e.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	public static void textboxClear(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException {

		String Status = null;
		try {

			Thread.sleep(2000);

			element.clear();

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

		} catch (Exception e) {
			System.out.println("Error occured while clearing the data");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription + " ERROR: -- " + e.getMessage());
		}
	}

}
