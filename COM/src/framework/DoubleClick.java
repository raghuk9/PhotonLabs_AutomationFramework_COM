package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
	
	public static Set<String>  doubleclick(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles) throws IOException, ParseException
	
			{
		String Status = null;
		String Windowid=null;
		
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
			 Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				System.out.println(driver.getWindowHandle());
			}
			// this is to double click on the webelement
			
			Actions click_action = new Actions(driver);
			click_action.moveToElement(webelement).doubleClick().build().perform();
			
			Thread.sleep(3000);
			
			if (!viewPort.toUpperCase().equals("APPIUM"))
			{
			windowhandles=driver.getWindowHandles();
			}
			
			
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
		return windowhandles;
	}

}
