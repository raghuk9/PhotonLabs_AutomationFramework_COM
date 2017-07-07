package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class BackButton {

	// This is to click on the back button
	public void backButton(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
			Set<String> windowhandles, ExtentTest test) throws InterruptedException {
		if (!driver.equals("safari")) {
			((JavascriptExecutor) driver).executeScript("javascript: setTimeout(\"history.go(-1)\", 2000)");
		} else {
			System.out.println("Navigating to Back--Pass");
		}
		try {
			Thread.sleep(2000);
			driver.navigate().back();
			System.out.println("Navigating to Back--Pass");

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription + " Navigated Back");

		} catch (Exception e) {
			System.out.println("Navigating to Back--ERROR");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
		}
	}

}
