package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WaitMethod {

	public void waitMethod(String viewPort, String functionality, String driverExecute, String testCaseno,
						   String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
						   WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j, String report, String application, String startTm, String endTm,
						   Set<String> windowhandles, ExtentTest test) throws InterruptedException {
		int value = Integer.parseInt(testData);
		
		Thread.sleep(value);
	}
	

}
