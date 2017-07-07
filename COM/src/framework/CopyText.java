package framework;


import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class CopyText {

	public void copyText(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles, ExtentTest test)
			throws InterruptedException {
		try {
			Thread.sleep(500);
			if ( testData.toUpperCase().equals("WINDOWS")) {
				webelement.sendKeys(Keys.chord(Keys.CONTROL, "c"));			
				System.out.println(testCaseno+" "+testCaseDescription+" --Pass");
			}
			else {
				webelement.sendKeys(Keys.chord(Keys.COMMAND, "c"));			
				System.out.println(testCaseno+" "+testCaseDescription+" --Pass");
			}

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

		} catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
			
			System.out.println(e.getMessage());

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
			
		
	}
	}
}
