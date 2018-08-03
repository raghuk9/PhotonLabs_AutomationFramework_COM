package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class AlertMessage {
	String Status = null;
	public void alertMessage(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			String DriverToInvoke, String TakeScreenshot, WebDriver driver, String oldValue, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
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

			Status = "Pass";

			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not able to perform action on the alert message--ERROR");
			Status = "Fail";

			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
					test, TakeScreenshot);
					
		}
		
	}	
}
