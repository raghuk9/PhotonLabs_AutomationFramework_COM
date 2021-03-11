package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class Submit {
	
	public void submit(String viewPort, String functionality,
					   String driverExecute, String testCaseno,
					   String testCaseDescription, String testCaseExecute,
					   WebElement webelement, String testData, String action,
					   WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
					   String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	{
		String Status=null;
		if (!viewPort.toUpperCase().equals("APPIUM")) {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
			//windowhandles.add(Windowid);
		}
		
		webelement.submit();
		try
		{

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Pass";
			System.out.println(testCaseno+ "Submitted the page successfully");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

		}
	
	} catch (Exception e) {

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Fail";
			System.out.println(testCaseno+" " +
					"Not able to submit the page");
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

		}
		
		
	}
	}
}


