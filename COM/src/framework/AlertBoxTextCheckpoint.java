package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;



public class AlertBoxTextCheckpoint {
	public void alertBoxTextCheckpoint(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			String DriverToInvoke, String TakeScreenshot, WebDriver driver, String oldValue, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException {

		String Status = null;
		System.out.println(driver.switchTo().alert().getText());

		if (driver.switchTo().alert().getText().equals(testData)) {
			System.out.println(testCaseno + " " + testCaseDescription + "--PASS");

			Status = "Pass";

			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);
		} else {
			System.out.println(testCaseno + " " + testCaseDescription + "--FAIL");
			Status = "Fail";

			try {
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}

	}
	
	@SuppressWarnings("rawtypes")
	public void alertBoxTextCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement element, String testData, String action,
			AppiumDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test)
			throws IOException, ParseException, InterruptedException {

		String Status = null;
		if (element.getText().equals(testData)) {
			System.out.println(testCaseno + " " + testCaseDescription + "--PASS");

			Status = "Pass";

			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);
		} else {
			System.out.println(testCaseno + " " + testCaseDescription + "--FAIL");
			Status = "Fail";

			try {
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
						test, TakeScreenshot);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	}
}
