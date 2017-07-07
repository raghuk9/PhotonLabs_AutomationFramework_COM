package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class TextboxContentCheckpoint {
	
	
	public void textboxContentCheckpoint(String viewPort, String functionality,
										 String driverExecute, String testCaseno,
										 String testCaseDescription, String testCaseExecute,
										 WebElement webelement, String testData, String action,
										 WebDriver driver, String oldValue, int j,
										 String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException
	
	
	
	{
		
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
            Thread.sleep(3000);
			String value=webelement.getAttribute("value");
			System.out.println(testData);
			System.out.println(value);
			if(value.equals(testData))
			{

				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
                System.out.println(testCaseno+" "+testCaseDescription+" --Pass");
                Results.results(testCaseno, testCaseDescription, Status,
    					viewPort, application, startTm, endTm, driver);
				}
			}
			
			else
			{

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
                    System.out.println(testCaseno+" "+testCaseDescription+" --failed");
                    Results.results(testCaseno, testCaseDescription, Status,
        					viewPort, application, startTm, endTm, driver);
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println("Not able to perform operation on the textbox");

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
