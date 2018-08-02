package framework;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class AlertMessage {
	
	public void alertMessage(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test)
	{
		try
		{
			
			if(testData.toUpperCase().equals("ACCEPT"))
			{
				driver.switchTo().alert().accept();
				
				System.out.println("Clicked on the accept button");
			}
			else if(testData.toUpperCase().equals("DECLINE"))
			{
				driver.switchTo().alert().dismiss();
				System.out.println("Clicked on the decline button");
			}

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not able to perform action on the alert message--ERROR");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
		}
		
	}	
}
