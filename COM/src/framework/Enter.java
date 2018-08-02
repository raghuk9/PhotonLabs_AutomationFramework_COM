package framework;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class Enter {
	String Status = null;

	public void enter(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws InterruptedException, IOException, ParseException {
		try {
			Thread.sleep(500);
			webelement.sendKeys(Keys.ENTER);

			System.out.println(testCaseno + " " + testCaseDescription + " --Pass");
			Status = "Pass";
			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --ERROR");

			System.out.println(e.getMessage());
			Status = "Fail";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

		}
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void enter(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws InterruptedException, IOException, ParseException {
		try {
			Thread.sleep(500);
			((AndroidDriver) driver).pressKeyCode(66);

			System.out.println(testCaseno + " " + testCaseDescription + " --Pass");
			Status = "Pass";
			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --ERROR");

			System.out.println(e.getMessage());
			Status = "Fail";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

		}
	}
}
