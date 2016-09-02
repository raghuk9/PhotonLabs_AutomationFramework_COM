package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickAT {
	
	public void clickAT(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles)
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
		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Pass";
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
     	}
		
     //this is catch statement
	} 
	catch (Exception e) {
		System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Fail";
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
			
			
		}
	}
		
	}
}
			
			
