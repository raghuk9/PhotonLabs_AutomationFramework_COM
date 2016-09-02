package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ListBoxSelectedValueCheckpoint {
	public void listBoxSelectedValueCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles)
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

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";

					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				}
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as "
						+ Select.getFirstSelectedOption().getText());
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";

					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				}
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
