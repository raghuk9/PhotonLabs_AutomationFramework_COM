package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Scrolling {
	public void scrolling(String viewPort, String functionality,
						  String driverExecute, String testCaseno,
						  String testCaseDescription, String testCaseExecute,
						  WebElement webelement, String testData, String action,
						  WebDriver driver, String oldValue, int j,
						  String report, String application, String startTm, ExtentTest test) throws InterruptedException,
			IOException {

		// This code is to scroll the webpage up to the 200 points 
		
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,200)", "");

		// extent report for status pass
		test.pass(testCaseno + " " + testCaseDescription);

	}
}
