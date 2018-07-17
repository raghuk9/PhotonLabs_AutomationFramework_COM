
package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class Maximize {

	public void maximize(String viewPort, String functionality, String driverExecute, String testCaseno,
						 String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
						 WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j, String report, String application, String startTm, String endTm,
						 Set<String> windowhandles, ExtentTest test) throws InterruptedException, IOException, ParseException {
		String Status = null;
		try {
			Thread.sleep(1000);
			driver.manage().window().maximize();

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --Failed");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
			}
		}
	}

}
