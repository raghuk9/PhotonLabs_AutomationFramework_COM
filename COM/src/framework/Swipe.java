package framework;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.Set;


public class Swipe {
	
		public static Set<String>  swipe(String viewPort, String functionality,
										 String driverExecute, String testCaseno,
										 String testCaseDescription, String testCaseExecute,
										 MobileElement element, String testData, String action,
										 AppiumDriver driver, String oldValue,String DriverToInvoke, String TakeScreenshot, int j,
										 String report, String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException
	
			{
		System.out.println("Mobile swiping");
		String Status = null;
		String Windowid=null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
			 Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				System.out.println(driver.getWindowHandle());
			}
			// this is to tap on the mobilelement
//			element.tap(1,1);
			System.out.println("before...");
			MobileDriver mdriver = null;
			@SuppressWarnings("rawtypes")
	    
			TouchAction action1 = new TouchAction(mdriver);
			
			action1.press(PointOption.point(300,152))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(40,152))
				.release()
				.perform();
			//action1.press(532, 241).waitAction(500).moveTo(138, 241).release().perform();
			//action1.press(532, 241).waitAction(500).moveTo(138, 241).release().perform();
			//action1.press(532, 241).waitAction(500).moveTo(138, 241).release().perform();
			System.out.println("after...");
			
			//element.swipe(270, 265, 130, 265, 500);
			
			Thread.sleep(3000);
			
			if (!viewPort.toUpperCase().equals("APPIUM"))
			{
			windowhandles=driver.getWindowHandles();
			}
			
			
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
;
			}
		}
		return windowhandles;
	}

}
