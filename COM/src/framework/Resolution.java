package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Resolution {
	public void resolution(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles)
			throws InterruptedException, IOException, ParseException {
		String Status = null;
		try { 
			String[] Sizes = testData.split(",");
			int x = Integer.parseInt(Sizes[0]);
			int y = Integer.parseInt(Sizes[1]);
			//this 

			driver.manage().window().setSize(new Dimension(x, y));
			System.out.println("Resizing window to ("+x+","+y+")");
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
