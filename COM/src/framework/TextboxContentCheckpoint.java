package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;

public class TextboxContentCheckpoint {

	public void textboxContentCheckpoint(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException

	{

		String Status = null;
		try {
			if (viewPort.toUpperCase().equals("DESKTOP")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			Thread.sleep(3000);
			String value = webelement.getAttribute("value");
			System.out.println(testData);
			System.out.println(value);
			if (value.equals(testData)) {

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					System.out.println(testCaseno + " " + testCaseDescription + " --Pass");
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
							driver, test, TakeScreenshot);

				}
			}

			else {

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					System.out.println(testCaseno + " " + testCaseDescription + " --failed");
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
							driver, test, TakeScreenshot);

				}

			}

		} catch (Exception e) {
			System.out.println("Not able to perform operation on the textbox");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription + " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			}
		}

	}

	@SuppressWarnings("rawtypes")
	public void textboxContentCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement element, String testData, String action,
			AppiumDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException

	{

		String Status = null;
		try {
			
			Thread.sleep(3000);
			String value = element.getAttribute("text");
			System.out.println(testData);
			System.out.println(value);
			if (value.equals(testData)) {

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					System.out.println(testCaseno + " " + testCaseDescription + " --Pass");
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
							driver, test, TakeScreenshot);

				}
			}

			else {

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					System.out.println(testCaseno + " " + testCaseDescription + " --failed");
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
							driver, test, TakeScreenshot);

				}

			}

		} catch (Exception e) {
			System.out.println("Not able to perform operation on the textbox");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription + " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			}
		}

	}

}
