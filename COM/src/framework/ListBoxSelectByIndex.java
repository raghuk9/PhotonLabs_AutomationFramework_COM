package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ListBoxSelectByIndex {
	
	public void listBoxSelectByIndex(String viewPort, String functionality,
									 String driverExecute, String testCaseno,
									 String testCaseDescription, String testCaseExecute,
									 WebElement webelement, String testData, String action,
									 WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
									 String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	{
		String Status=null;
		try
		{
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			int index=Integer.parseInt(testData);
			org.openqa.selenium.support.ui.Select select=new org.openqa.selenium.support.ui.Select(webelement);
			select.selectByIndex(index);
			System.out.println("Selected an item from list box  using index");

		
			if (report.toUpperCase().equals("TESTSTEP")) {

				Status = "Pass";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		
		}
		
		catch(Exception e)
		{
			System.out.println("Not able to select an list box element using index");

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		}
		
	}

}
