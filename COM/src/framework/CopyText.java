package framework;


import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class CopyText {
	String Status = null;
	public void copyText(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test)
			throws InterruptedException, IOException, ParseException {
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

			Status = "Pass";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);


		} catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
			
			System.out.println(e.getMessage());

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			
		
	}
	}
	}
	}
