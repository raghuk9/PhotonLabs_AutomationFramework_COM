package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ListBoxDeSelectByValue {
	
	public void listBoxDeSelectByValue(String viewPort, String functionality,
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
			//int index=Integer.parseInt(testData);
			org.openqa.selenium.support.ui.Select select=new org.openqa.selenium.support.ui.Select(webelement);
			select.deselectByValue(testData);
			System.out.println("Deselected an item from list box  using Value");


			if (report.toUpperCase().equals("TESTSTEP")) {

				Status = "Pass";
				
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		}
		
		
		catch(Exception e)
		{
			System.out.println("Not able to deselect an list box element using value--ERROR");


			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			}
		}
	}

}
