package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class Resolution {
	public void resolution(String viewPort, String functionality,
						   String driverExecute, String testCaseno,
						   String testCaseDescription, String testCaseExecute,
						   WebElement webelement, String testData, String action,
						   WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
						   String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws InterruptedException, IOException, ParseException {
		String Status = null;
		try { 
			String[] Sizes = testData.split(",");
			int x = Integer.parseInt(Sizes[0]);
			int y = Integer.parseInt(Sizes[1]);
			//this 

			driver.manage().window().setSize(new Dimension(x, y));
			System.out.println("Resizing window to ("+x+","+y+")");

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
