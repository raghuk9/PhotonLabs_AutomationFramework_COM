package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextboxValidation {
public void textboxWithAlphabetsSpecialCharachters(String viewPort, String functionality,
												   String driverExecute, String testCaseno,
												   String testCaseDescription, String testCaseExecute,
												   WebElement webelement, String testData, String action,
												   WebDriver driver, String oldValue, int j, String report, String application, String startTm, ExtentTest test)
{
	

	try {
		Thread.sleep(1000);
		if (!viewPort.toUpperCase().equals("APPIUM")) {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
		
		}
		
		if(testData.toUpperCase().equals("ALPHABET"))
		{
			
			String Value="alphabet";
			for(int i=0;i<Value.length();i++)
			{
				String s= Character.toString(Value.charAt(i));
				webelement.sendKeys(s);
			}
			
			String getValue=webelement.getCssValue("value");
			
			if(getValue.equals(Value))
			{
				System.out.println("Able to enter alphabets in to the text box field");
			}
			else
			{
				System.out.println("Not able to enter alphabets in to the text box field");
			}
		}
		if(testData.toUpperCase().equals("SPECIALS"))
		{
			
			String Value="%$#@()!@";
			for(int i=0;i<Value.length();i++)
			{
				String s= Character.toString(Value.charAt(i));
				webelement.sendKeys(s);
			}
			String getValue=webelement.getCssValue("value");
			if(getValue.equals(Value))
			{
				System.out.println("Able to enter Special characters in to the text box field");
			}
			else
			{
				System.out.println("Not able to enter Special characters in to the text box field");
			}
		}
		if(testData.toUpperCase().equals("SPACE"))
		{
			String Value="   ";
			for(int i=0;i<Value.length();i++)
			{
				String s= Character.toString(Value.charAt(i));
				webelement.sendKeys(s);
				
			}
			String getValue=webelement.getCssValue("value");
			if(getValue.equals(Value))
			{
				System.out.println("Able to enter Spaces in to the text box field");
			}
			else
			{
				System.out.println("Not able to enter spaces in to the text box field");
			}
		}

		// extent report for status pass
		test.pass(testCaseno + " " + testCaseDescription);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());

		// extent report for status fail
		test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
	}
		
}
}
