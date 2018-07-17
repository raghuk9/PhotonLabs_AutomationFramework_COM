package framework;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

public class AllElementsInTheRadioButtonsCheckpoints {
	public void allElementsInTheRadioButtonsCheckpoints(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot,int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles, ExtentTest test) throws IOException, ParseException, InterruptedException {
		String Status = null;
		try {

			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			
			
			
 
			List<WebElement> List = webelement
					.findElements(By.tagName("input"));
			String[] Values = testData.split(",");
			int i = 0;
			for (WebElement Radioitem : List) {
				if (Radioitem.getText().equals(Values[i])) {
					i = i + 1;
				}
			}
			if (i == List.size()) {
				System.out.println("All radio Butotns are there");
				
					Status = "Pass";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status pass
				//test.pass(testCaseno + " " + testCaseDescription);
				
			} else {
				System.out.println("All Radio buttons are not there");
				
					Status = "Fail";
					
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

				// extent report for status fail
				//test.fail(testCaseno + " " + testCaseDescription);
				
			}
		} catch (Exception e) {
			
				Status = "Fail";
				System.out.println("ERROR");
				
				Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver, test, TakeScreenshot);

			// extent report for status fail
			//test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());
			
		}
	}
}
