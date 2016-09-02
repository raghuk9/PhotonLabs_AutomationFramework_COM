package framework;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextboxLengthValidation {

	public void textboxLengthValidation(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}

			String[] values = testData.split(",");
			int length = Integer.parseInt(values[0]);
			String charachter = values[1];
			for (int i = 0; i <= length; i++) {
				webelement.sendKeys(charachter);
			}
			String str = webelement.getAttribute("value");

			
			if (str.length() == length) {

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";

					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				}
				System.out
						.println("text box is accepting the desired charachter");
			} else {
				System.out
						.println("Text box is not accepting the desired characheters");
			}
		} catch (Exception e) {
			System.out.println("Not able to perform operation on the textbox");
		}

	}

}
