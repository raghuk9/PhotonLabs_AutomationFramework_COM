package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ScrollToElement {
public static void scrollToElement(String viewPort, String functionality,
								   String driverExecute, String testCaseno,
								   String testCaseDescription, String testCaseExecute,
								   WebElement webelement, String testData, String action,
								   WebDriver driver, String oldValue, int j,
								   String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
{
	try
	{
		if (!viewPort.toUpperCase().equals("APPIUM")) {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
			//windowhandles.add(Windowid);
			
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webelement);
		System.out.println("Scrolled to element");

		// extent report for status pass
		test.pass(testCaseno + " " + testCaseDescription);
		
	}
	catch(Exception e)
	{
		System.out.println("Not able to scroll error");

		// extent report for status fail
		test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
	}
	
	
}
}
