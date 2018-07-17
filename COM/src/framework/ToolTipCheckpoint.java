package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ToolTipCheckpoint {
	
	public void toolTipCheckpoint(String viewPort, String functionality,
								  String driverExecute, String testCaseno,
								  String testCaseDescription, String testCaseExecute,
								  WebElement webelement, String testData, String action,
								  WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
								  String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	{
		String Status=null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			
            String toolTip=webelement.getAttribute("title");
			if(toolTip.equals(testData))
			{
				System.out.println(testCaseno+" "+testCaseDescription+" Tool tip is getting displaying correctly");
				Status = "Pass";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);
;

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);
			}
			else
			{
				Status = "Fail";
                System.out.println(testCaseno+" "+testCaseDescription+" Tool tip not matched");
    			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);
			}

		} catch (Exception e) {
            System.out.println(testCaseno+" "+testCaseDescription+" Not able to capture the tool tip");
			Status = "Fail";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);


			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

		}
		
	}

}
