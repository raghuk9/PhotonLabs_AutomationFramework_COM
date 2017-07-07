package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ScrollAndroid {
	
	
	public static void scrollAndroid(String viewPort,
									 String functionality, String driverExecute, String testCaseno,
									 String testCaseDescription, String testCaseExecute,
									 WebElement webelement, String testData, String action,
									 WebDriver driver, String oldValue, int j,
									 String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
	{
		try
		{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)");

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
		}
	}

}
