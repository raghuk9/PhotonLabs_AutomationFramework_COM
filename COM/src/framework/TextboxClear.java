package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class TextboxClear {
	
	
	public static void textboxClear(String viewPort, String functionality,
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

			Thread.sleep(2000);

			
			webelement.clear();


			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);
		
		} catch (Exception e) {
			System.out.println("Error occured while clearing the data");

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
			}
	}

	}

