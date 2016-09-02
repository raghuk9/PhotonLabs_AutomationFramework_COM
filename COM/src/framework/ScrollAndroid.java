package framework;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollAndroid {
	
	
	public static void scrollAndroid(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles)
	{
		try
		{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
