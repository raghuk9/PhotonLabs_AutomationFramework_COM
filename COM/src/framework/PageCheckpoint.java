package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class PageCheckpoint {

	public void pageCheckpoint(String viewPort, String functionality,
							   String driverExecute, String testCaseno,
							   String testCaseDescription, String testCaseExecute,
							   WebElement webelement, String testData, String action,
							   WebDriver driver, String oldValue, int j,
							   String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException,InterruptedException {
		String Status = null;
		
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
           String actualTitle=driver.getTitle();
           System.out.println(actualTitle.length());
           System.out.println(testData.length());
           
           System.out.println(actualTitle);
           System.out.println(testData);
           
			if (actualTitle.equals(testData)) {
				System.out.println(testCaseno + " " + testCaseDescription
						+ " --Pass");
				Status = "Pass";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

			} else {

				Status = "Fail";
				System.out.println(testCaseno + " " + testCaseDescription
						+ " --Failed");
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);
			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription
					+ " --NotFound");
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

		}

	}
}
