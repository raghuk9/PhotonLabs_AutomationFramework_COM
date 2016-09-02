package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IsCheckboxDeSelected {
	
	
	public  void isCheckboxDeSelected(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		
		String Status = null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			
			
			if(!webelement.isSelected())
			{
				System.out.println(testCaseno+" "+testCaseDescription+" --Pass");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				}
			
			}
			else
				
			{
				System.out.println(testCaseno+" "+testCaseDescription+" --Failed");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				}
			}
		
	}
		catch(Exception e)
		{
			System.out.println(testCaseno+" "+testCaseDescription+" --Unexpected error");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
			
		}
	}
	
}
