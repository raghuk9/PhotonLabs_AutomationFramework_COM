package framework;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class TextCheckpoint {
	public void textCheckpoint(String viewPort, String functionality, String driverExecute, String testCaseno,
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
			}

			Thread.sleep(2000);
			System.out.println(webelement.getText());
			System.out.println(testData);
			System.out.println(webelement.getText().length());
			System.out.println(testData.length());
			if (webelement.getText().trim().equals(testData.trim())) {
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

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);
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
	public void textCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement element, String testData, String action,
			AppiumDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			System.out.println(testCaseno + " " + testCaseDescription);

			Thread.sleep(2000);
			System.out.println(element.getText());
			System.out.println(testData);
			System.out.println(element.getText().length());
			System.out.println(testData.length());
			if (element.getText().trim().equals(testData.trim())) {
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

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);
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
