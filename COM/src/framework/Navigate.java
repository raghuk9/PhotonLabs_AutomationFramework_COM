package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navigate {
	public void navigate(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles)
			throws InterruptedException, IOException, ParseException {

		System.out.println(testCaseno+" Navigating to "+testData);
		
		String Status = null;
		
		try {
			driver.get(testData);
			Thread.sleep(4000);
	        System.out.println(testCaseno+" Navigating to "+testData+ " is done");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}

		}

	}
}
