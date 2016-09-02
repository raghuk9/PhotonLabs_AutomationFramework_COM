package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataCheckpointNegetive {
	public void dataCheckpointNegetive(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles) throws IOException, ParseException {
		String Status = null;
		try {

			// Thread.sleep(5000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			if (!webelement.getText().equals(testData)) {
				System.out.println(testCaseDescription
						+ " Displaying correctly as " + webelement.getText());
                    Status = "Pass";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver); 
					
				 
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as " + webelement.getText());

				
					Status = "Fail";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				
			}
		} catch (Exception e) {
			
			    Status = "Fail";
				System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			
		}
	}
	
	public void dataCheckpointNegetive(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver,  String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles) throws IOException, ParseException {
		String Status = null;
		try {

			// Thread.sleep(5000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			if (!element.getText().equals(testData)) {
				System.out.println(testCaseDescription
						+ " Displaying correctly as " + element.getText());
                    Status = "Pass";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver); 
					
				 
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as " + element.getText());

				
					Status = "Fail";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				
			}
		} catch (Exception e) {
			
			    Status = "Fail";
				System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			
		}
	}
}