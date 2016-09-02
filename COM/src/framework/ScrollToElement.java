package framework;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement {
public static void scrollToElement(String viewPort, String functionality,
		String driverExecute, String testCaseno,
		String testCaseDescription, String testCaseExecute,
		WebElement webelement, String testData, String action,
		WebDriver driver,  String oldValue, int j,
		String report, String application, String startTm, String endTm,Set<String> windowhandles)
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
	}
	catch(Exception e)
	{
		System.out.println("Not able to scroll error");
	}
	
	
}
}
