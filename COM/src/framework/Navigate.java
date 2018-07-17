package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class Navigate {
	public void navigate(String viewPort, String functionality,
						 String driverExecute, String testCaseno,
						 String testCaseDescription, String testCaseExecute,
						 WebElement webelement, String testData, String action,
						 WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
						 String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws InterruptedException, IOException, ParseException {

		System.out.println(testCaseno+" Navigating to "+testData);
		
		String Status = null;
		
		try {
			driver.get(testData);
			Thread.sleep(4000);
	        System.out.println(testCaseno+" Navigating to "+testData+ " is done");

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		} catch (Exception e) {

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}

		}

	}
}
