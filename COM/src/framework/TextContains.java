package framework;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class TextContains {
	public void textContains(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			System.out.println(testCaseno + " " + testCaseDescription);
			if (viewPort.toUpperCase().equals("DESKTOP")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				// windowhandles.add(Windowid);
			}

			Thread.sleep(2000);
			System.out.println(webelement.getText());
			System.out.println(testData);
			System.out.println(webelement.getText().length());
			System.out.println(testData.length());
			if (webelement.getText().trim().contains(testData.trim())) {
				System.out.println(testCaseno + " " + testCaseDescription + "--PASS");
				Status = "Pass";
				Thread.sleep(2000);
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

			} else {
				System.out.println(testCaseno + " " + testCaseDescription + "--FAIL");
				Status = "Fail";

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription + "--Not able to compare the text--FAIL");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription + " ERROR: -- " + e.getMessage());

		}

	}

	@SuppressWarnings("rawtypes")
	public void textContains(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			System.out.println(testCaseno + " " + testCaseDescription);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				// windowhandles.add(Windowid);
			}

			Thread.sleep(2000);
			System.out.println(element.getText());
			System.out.println(testData);
			System.out.println(element.getText().length());
			System.out.println(testData.length());
			if (element.getText().trim().contains(testData.trim())) {
				System.out.println(testCaseno + " " + testCaseDescription + "--PASS");
				Status = "Pass";
				Thread.sleep(2000);
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

			} else {
				System.out.println(testCaseno + " " + testCaseDescription + "--FAIL");
				Status = "Fail";

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription + "--Not able to compare the text--FAIL");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription + " ERROR: -- " + e.getMessage());

		}

	}
}
