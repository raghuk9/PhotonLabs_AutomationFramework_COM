package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Results;

public class ListBoxSelectByVisibleText {
	
	public void listBoxSelectByVisibleText(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		String Status=null;
		try
		{
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			//int index=Integer.parseInt(testData);
			org.openqa.selenium.support.ui.Select select=new org.openqa.selenium.support.ui.Select(webelement);
			
			select.selectByVisibleText(testData);
			System.out.println("Selected an item from list box  using visible text");
			if (report.toUpperCase().equals("TESTSTEP")) {

				Status = "Pass";
				
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
		}
		
		
		catch(Exception e)
		{
			System.out.println("Not able to select an list box element using visible text");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
		}
	}
		
	}


