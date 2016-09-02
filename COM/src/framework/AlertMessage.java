package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertMessage {
	
	public void alertMessage(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles)
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
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not able to perform action on the alert message--ERROR");
		}
		
	}

	public void alertMessage(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles)
	{
		try
		{
			
			if(testData.toUpperCase().equals("ACCEPT"))
			{
				driver.switchTo().alert().accept();
				
				System.out.println("tapped on the accept button");
			}
			else if(testData.toUpperCase().equals("DECLINE"))
			{
				driver.switchTo().alert().dismiss();
				System.out.println("tapped on the decline button");
			} 
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not able to perform action on the alert message--ERROR");
		}
		
	}

}
