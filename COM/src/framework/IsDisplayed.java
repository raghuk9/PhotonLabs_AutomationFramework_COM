package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class IsDisplayed {

	public static void isDisplayed(String viewPort, String functionality, String driverExecute, String testCaseno,
								   String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
								   WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
								   Set<String> windowhandles, ExtentTest test) throws IOException, ParseException {
		String Status = null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				// windowhandles.add(Windowid);
			}
			if (webelement.isDisplayed()) {
				System.out.println(testCaseno + " " + testCaseDescription + " --Pass");

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm,
							driver);
				}
			} else {
				System.out.println(testCaseno + " " + testCaseDescription + " --Failed");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm,
							driver);
				}
			}
		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --Unexpected error");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm, driver);

			}
		}
	}

}
