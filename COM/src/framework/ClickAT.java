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
			if (!viewPort.toUpperCase().equals("APPIUM")) {
			 Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				System.out.println(driver.getWindowHandle());
			}
			System.out.println("statrted analysing the xand y");
			
			String a [] = testData.split(",");
	        for (int i = 0; i < a.length; i++){
	           // System.out.println(a[i]);
	          //  System.out.println(a[0]);
	        }
	        int x = Integer.parseInt(a[0]);
	        int y = Integer.parseInt(a[1]);
			
//	        Actions builder = new Actions(driver);   
//	        builder.moveByOffset(x,y).clickAndHold().release().perform();
	        
	        Actions builder = new Actions(driver);   
	        builder.moveByOffset(x,y).click().perform();
	       
	        System.out.println("Xvalue is:" +x);
	        System.out.println("Yvalue is:" +y);
			
//	    String[] pointx =testData.split(",", 2);
//			
//		System.out.println("Xvalue is :"+pointx[1]);
//		int x = Integer.parseInt(pointx[0]);
//		System.out.println("Integer Xvalue is :"+x);
	    	
//		for (String pointy: testData.split(",", 2))
//		
//			System.out.println("Y Value is:" +pointy);
//		{
//			int x = Integer.parseInt(pointx);
//			int y = Integer.parseInt(pointy);
//			System.out.println(x);
//			System.out.println(y);
//		
//		Actions builder = new Actions(driver);   
//		builder.moveByOffset(x,y).clickAndHold().release().perform();
//		}
//	     
//		if (!viewPort.toUpperCase().equals("APPIUM"))
//		{
//		windowhandles=driver.getWindowHandles();
//		}
		
		
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

		// extent report for status fail
		test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Fail";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

		}
	}
		
	}
}
			
			
