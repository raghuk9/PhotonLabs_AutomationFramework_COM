package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class TextBox {
	public void textBox(String viewPort, String functionality,
						String driverExecute, String testCaseno,
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

			Thread.sleep(2000);

			//System.out.println("success");
			// webelement.click();
			System.out.println(testCaseno+" Trying to enter " + testData
					+ " In to the text box ");
			
			//webelement.clear();
			//System.out.println("success");
			webelement.sendKeys(testData);


			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				System.out.println(testCaseno+ " Entered " + testData
						+ " In to the text box sucessfully");
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
						application, driver, test, TakeScreenshot);
			}
		
		} catch (Exception e) {

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				System.out.println(testCaseno+" " +
						"Not able to enter " + testData
						+ " In to the text box");
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
						application, driver, test, TakeScreenshot);
			}
		}
	}
}
