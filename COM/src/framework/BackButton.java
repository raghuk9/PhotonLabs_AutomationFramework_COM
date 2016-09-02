package framework;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackButton {

	// This is to click on the back button
	public void backButton(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
			Set<String> windowhandles) throws InterruptedException {
		if (!driver.equals("safari")) {
			((JavascriptExecutor) driver).executeScript("javascript: setTimeout(\"history.go(-1)\", 2000)");
		} else {
			System.out.println("Navigating to Back--Pass");
		}
		try {
			Thread.sleep(2000);
			driver.navigate().back();
			System.out.println("Navigating to Back--Pass");
		} catch (Exception e) {
			System.out.println("Navigating to Back--ERROR");
		}
	}

}
