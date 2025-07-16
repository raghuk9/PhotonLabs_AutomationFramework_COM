package framework;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ParagraphCheckpoint {

	public static void paragraphCheckpoint(String viewPort, String functionality, String driverExecute,
			String testCaseno, String testCaseDescription, String testCaseExecute, WebElement webelement,
			String testData, String action, WebDriver driver, String oldValue, String DriverToInvoke,
			String TakeScreenshot, int j, String report, String application, String startTm, String endTm,
			Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			System.out.println(testCaseno + " " + testCaseDescription);
			if (viewPort.toUpperCase().equals("DESKTOP")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);

			}

			Thread.sleep(500);

			String actualText = webelement.getText().replace("\\r\\n|\\r|\\n", "");
			String expectedText = testData.replace("\\r\\n|\\r|\\n", "");

			System.out.println(actualText);
			System.out.println(expectedText);
			System.out.println(actualText.length());
			System.out.println(actualText.length());

			if (actualText.equals(expectedText)) {
				System.out.println(testCaseno + " " + testCaseDescription + "--PASS");

				Status = "Pass";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			
			} else {
				System.out.println(testCaseno + " " + testCaseDescription + "--FAIL");
				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription + "--Not able to compare the text--FAIL");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

			
		}
	}

	@SuppressWarnings("rawtypes")
	public static void paragraphCheckpoint(String viewPort, String functionality, String driverExecute,
			String testCaseno, String testCaseDescription, String testCaseExecute, WebElement element,
			String testData, String action, AppiumDriver driver, String oldValue, String DriverToInvoke,
			String TakeScreenshot, int j, String report, String application, String startTm, String endTm,
			Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			System.out.println(testCaseno + " " + testCaseDescription);
			Thread.sleep(500);

			String actualText = element.getText().replace("\\r\\n|\\r|\\n", "");
			String expectedText = testData.replace("\\r\\n|\\r|\\n", "");

			System.out.println(actualText);
			System.out.println(expectedText);
			System.out.println(actualText.length());
			System.out.println(actualText.length());

			if (actualText.equals(expectedText)) {
				System.out.println(testCaseno + " " + testCaseDescription + "--PASS");

				Status = "Pass";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			
			} else {
				System.out.println(testCaseno + " " + testCaseDescription + "--FAIL");
				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription + "--Not able to compare the text--FAIL");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

			
		}
	}

}
