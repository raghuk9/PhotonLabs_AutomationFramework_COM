package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowHandling {

	public void windowHandling(String viewPort, String functionality, String driverExecute, String testCaseno,
							   String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
							   WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
							   Set<String> windowhandles, ExtentTest test) throws InterruptedException {
		Set handles = driver.getWindowHandles();
		String firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String secondWinHandle = (String) handles.iterator().next();
		if (secondWinHandle != firstWinHandle) {
			System.out.println("first time");
			driver.switchTo().window(secondWinHandle);
		}

		// extent report for status pass
		test.pass(testCaseno + " " + testCaseDescription);
	}
}
