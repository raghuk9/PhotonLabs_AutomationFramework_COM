package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;

public class RowsInGrid {

	public static void rowsInGrid(String viewPort, String functionality, String driverExecute, String testCaseno,
								  String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
								  WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j, String report, String application, String startTm, String endTm,
								  String ObjectIdentifier, ExtentTest test) throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			java.util.List<WebElement> rows = driver.findElements(By.xpath(ObjectIdentifier));
			int rowCount = rows.size();
			int Data = Integer.parseInt(testData);
			if (rowCount == Data) {
				System.out.println("No of rows are displaying as" + rowCount + "--Pass");

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				}
			} else {
				System.out.println("No of rows are " + rowCount + "--Fail");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				}
			}
		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --Failed");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		}
	}

}
