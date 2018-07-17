package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ListBoxDeselectAll { 
	
	public void listBoxDeselectAll(String viewPort, String functionality,
								   String driverExecute, String testCaseno,
								   String testCaseDescription, String testCaseExecute,
								   WebElement webelement, String testData, String action,
								   WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
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
			select.deselectAll();
			System.out.println("Deselected all items");

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
						application, driver, test, TakeScreenshot);
			}
		}
		
		
		catch(Exception e)
		{
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				
				try {
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
							application, driver, test, TakeScreenshot);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
