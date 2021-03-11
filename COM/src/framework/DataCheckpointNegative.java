package framework;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class DataCheckpointNegative {
	public void dataCheckpointNegative(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			// Thread.sleep(5000);
			if (viewPort.toUpperCase().equals("DESKTOP")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			if (!webelement.getText().equals(testData)) {
				System.out.println(testCaseDescription + " Displaying correctly as " + webelement.getText());
				Status = "Pass";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

				
			} else {
				System.out.println(testCaseDescription + " Displaying incorrectly as " + webelement.getText());

				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);

				
			}
		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription + " --ERROR");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

		}
	}

	@SuppressWarnings("rawtypes")
	public void dataCheckpointNegetive(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			if (!element.getText().equals(testData)) {
				System.out.println(testCaseDescription + " Displaying correctly as " + element.getText());
				Status = "Pass";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);


			} else {
				System.out.println(testCaseDescription + " Displaying incorrectly as " + element.getText());

				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);


			}
		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription + " --ERROR");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);

		}
	}
}
