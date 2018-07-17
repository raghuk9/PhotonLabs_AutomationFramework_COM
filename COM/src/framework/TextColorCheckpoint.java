package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class TextColorCheckpoint {
	
	public void textColorCheckpoint(String viewPort, String functionality,
									String driverExecute, String testCaseno,
									String testCaseDescription, String testCaseExecute,
									WebElement webelement, String testData, String action,
									WebDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
									String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	{
		
		
		String Status = null;

		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			String color=webelement.getCssValue("color");
			System.out.println(color);
			String[] values=color.split("\\(");
			//System.out.println(abcd[0]);
			
			String[] rgbvalues=values[1].split(",");
			int r=Integer.parseInt(rgbvalues[0].trim());
			int g=Integer.parseInt(rgbvalues[1].trim());
			int b=Integer.parseInt(rgbvalues[2].trim());
			System.out.println(r+" "+g+" "+b);
			
			Color newcolor=new Color(r, g, b);
			
			String hexcode="#"+Integer.toHexString(newcolor.getRGB()).substring(2);
			System.out.println(hexcode);
			
			if(hexcode.equals(testData))
			{
				System.out.println(testCaseno+" "+testCaseDescription+"Color is matching");
				Status = "Pass";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);


				// extent report for status pass
				test.pass(testCaseno + " " + testCaseDescription);
			}
			else
			{
				System.out.println(testCaseno+" "+testCaseDescription+"Color is not matching");
				Status = "Fail";

				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);


				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription);
			}
			
		}
		catch(Exception e)
		{
			
			System.out.println(testCaseno+" "+testCaseDescription+"not able to find the Color");
			Status = "Fail";

			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);


			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
			
		}
			
			
			
			
	}

}
