package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertBoxTextCheckpoint {
	public void alertBoxTextCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		
		
		String Status=null;		
		System.out.println(driver.switchTo().alert().getText());
		
		
		if(driver.switchTo().alert().getText().equals(testData))
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--PASS");

			Status = "Pass";

			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
		}
		else
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--FAIL");
			Status = "Fail";

			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
		}
		
	}
	
	
	public void alertBoxTextCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		
		
		String Status=null;
		System.out.println(driver.switchTo().alert().getText());
		
		
		if(driver.switchTo().alert().getText().equals(testData))
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--PASS");

			Status = "Pass";

			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
		}
		else
		{
			System.out.println(testCaseno+" "+testCaseDescription+"--FAIL");
			Status = "Fail";

			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
		}
		
	}	
	
	
}
