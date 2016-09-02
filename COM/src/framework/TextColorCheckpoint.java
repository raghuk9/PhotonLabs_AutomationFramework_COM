package framework;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextColorCheckpoint {
	
	public void textColorCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws IOException, ParseException
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

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
			else
			{
				System.out.println(testCaseno+" "+testCaseDescription+"Color is not matching");
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
			
		}
		catch(Exception e)
		{
			
			System.out.println(testCaseno+" "+testCaseDescription+"not able to find the Color");
			Status = "Fail";

			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
			
			
		}
			
			
			
			
	}

}
