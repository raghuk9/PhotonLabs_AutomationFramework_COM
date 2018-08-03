package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class IsCheckboxSelected {
	
	
	public  void isCheckboxSelected(String viewPort, String functionality,
									String driverExecute, String testCaseno,
									String testCaseDescription, String testCaseExecute,
									WebElement webelement, String testData, String action,
									WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
									String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	{
		
		String Status = null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			
			
			if(webelement.isSelected())
			{
				System.out.println(testCaseno+" "+testCaseDescription+" --Pass");

				
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				}
			
			}
			else
				
			{
				System.out.println(testCaseno+" "+testCaseDescription+" --Failed");

			

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
				}
			}
		
	}
		catch(Exception e)
		{
			System.out.println(testCaseno+" "+testCaseDescription+" --Unexpected error");
			
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
			}
			
		}
	}
	
}
