package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ListBoxSelectByValue {
	
	public void listBoxSelectByValue(String viewPort, String functionality,
									 String driverExecute, String testCaseno,
									 String testCaseDescription, String testCaseExecute,
									 WebElement webelement, String testData, String action,
									 WebDriver driver, String oldValue, int j,
									 String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException
	{
		String Status=null;
		try
		{
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			
			org.openqa.selenium.support.ui.Select select=new org.openqa.selenium.support.ui.Select(webelement);
			select.selectByValue(testData);
			System.out.println("Selected an item from list box  using Value");

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

			if (report.toUpperCase().equals("TESTSTEP")) {

				Status = "Pass";
				
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
		}
		
		
		catch(Exception e)
		{
			System.out.println("Not able to select an list box element using value");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);

			}
		}
	}

}
