package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ListBoxSelectedValueCheckpoint {
	public void listBoxSelectedValueCheckpoint(String viewPort,
											   String functionality, String driverExecute, String testCaseno,
											   String testCaseDescription, String testCaseExecute,
											   WebElement webelement, String testData, String action,
											   WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
											   String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws InterruptedException, IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}

			webelement.sendKeys(Keys.TAB);
			Select Select = new Select(webelement);
			Thread.sleep(5000);
			if (Select.getFirstSelectedOption().getText().equals(testData)) {
				System.out.println(testCaseDescription
						+ " Displaying correctly as "
						+ Select.getFirstSelectedOption().getText());

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";

					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				}
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as "
						+ Select.getFirstSelectedOption().getText());

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";

					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
				}
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
