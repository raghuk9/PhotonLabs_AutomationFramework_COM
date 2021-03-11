package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class ClickAT {
	
	public void clickAT(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles, ExtentTest test)
			throws InterruptedException, IOException, ParseException {
			
		
		String Status = null;
		String Windowid=null;
		try {
			Thread.sleep(1000);
			if (viewPort.toUpperCase().equals("DESKTOP")) {
			 Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			System.out.println("statrted analysing the xand y");
			
			String a [] = testData.split(",");
	        int x = Integer.parseInt(a[0]);
	        int y = Integer.parseInt(a[1]);
				        
	        Actions builder = new Actions(driver);   
	        builder.moveByOffset(x,y).click().perform();
	       
	        System.out.println("Xvalue is:" +x);
	        System.out.println("Yvalue is:" +y);
					
	        System.out.println(testCaseno+" "+testCaseDescription);

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);

		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Pass";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

     	}
		
     //this is catch statement
	} 
	catch (Exception e) {
		System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");

		
		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Fail";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

		}
	}
		
	}
}
			
			
