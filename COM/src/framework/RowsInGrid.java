package framework;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RowsInGrid {

	public static void rowsInGrid(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
			String ObjectIdentifier) throws IOException, ParseException {
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
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm,
							driver);
				}
			} else {
				System.out.println("No of rows are " + rowCount + "--Fail");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm,
							driver);
				}
			}
		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --Failed");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm, driver);
			}
		}
	}

}
