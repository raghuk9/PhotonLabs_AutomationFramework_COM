package framework;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
public class isEnabled {
		    public isEnabled (String viewPort, String functionality, String driverExecute, String testCaseno,
	                                   String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
	                                   WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
	                                   String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
	            throws IOException, ParseException, InterruptedException {
	        String Status = null;
	        try {
	            Thread.sleep(1000);
	            WebElement saveButton = driver.findElement(By.id(""));
	            Boolean checkSaveIsDisplayed = saveButton.isDisplayed();

	            if (checkSaveIsDisplayed == true) {
	            System.out.println("Button is displayed");
	            }
	            Boolean checkSaveIsEnabled = saveButton.isEnabled();

	            if (checkSaveIsEnabled == false) {
	            System.out.println("Button is not enabled");
	            }

	            // Click on a radio button then check if the save button is  enabled

	            WebElement radioButton = driver.findElement(By.id(""));

	            (new WebDriverWait(driver, 30)).until(ExpectedConditions
	            .elementToBeClickable(radioButton));

	            radioButton.click();

	            // check if it is now enabled
	            checkSaveIsEnabled = saveButton.isEnabled();
	            if (checkSaveIsEnabled == true) {
	            System.out.println("save button is enabled");

               // element.clear();
                System.out.println(testCaseno + " " + testCaseDescription + " --Pass");

                if (report.equalsIgnoreCase("TESTSTEP")) {
                    Status = "Pass";
                    Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
                            driver, test, TakeScreenshot);
	            
	            }
	            
	            } else {
	                    System.out.println(testCaseno + " " + testCaseDescription + " -- Failed");

	                    if (report.equalsIgnoreCase("TESTSTEP")) {
	                        Status = "Fail";
	                        Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
	                                driver, test, TakeScreenshot);
	                    }else {
	                        test.fail(testCaseno + " " + testCaseDescription);
	                    }
	                }
			
	        } catch (Exception e) {
	            System.out.println(testCaseno + " " + testCaseDescription + " --Unexpected error");


	            if (report.equalsIgnoreCase("TESTSTEP")) {
	                Status = "Fail";
	                Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
	                        test, TakeScreenshot);

	            }
	        }
	    }

	    @SuppressWarnings("rawtypes")
	    public static void isEditable(String viewPort, String functionality, String driverExecute, String testCaseno,
	                                   String testCaseDescription, String testCaseExecute, MobileElement element, String testData, String action,
	                                   AppiumDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
	                                   String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
	            throws IOException, ParseException, InterruptedException {
	        String Status = null;
	        try {
	            Thread.sleep(1000);
	            WebElement saveButton = driver.findElement(By.id(""));
	            Boolean checkSaveIsDisplayed = saveButton.isDisplayed();

	            if (checkSaveIsDisplayed == true) {
	            System.out.println("Button is displayed");
	            }
	            Boolean checkSaveIsEnabled = saveButton.isEnabled();

	            if (checkSaveIsEnabled == false) {
	            System.out.println("Button is not enabled");
	            }

	            // Click on a radio button then check if the save button is enabled

	            WebElement radioButton = driver.findElement(By.id(""));

	            (new WebDriverWait(driver, 30)).until(ExpectedConditions
	            .elementToBeClickable(radioButton));

	            radioButton.click();

	            // check if it is now enabled
	            checkSaveIsEnabled = saveButton.isEnabled();
	            if (checkSaveIsEnabled == true) {
	            System.out.println("save button is enabled");

                element.clear();
                System.out.println(testCaseno + " " + testCaseDescription + " --Pass");

                if (report.equalsIgnoreCase("TESTSTEP")) {
                    Status = "Pass";
                    Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
                            driver, test, TakeScreenshot);
	            
	            }
	            
	            } else {
	                System.out.println(testCaseno + " " + testCaseDescription + " --Failed");


	                if (report.equalsIgnoreCase("TESTSTEP")) {
	                    Status = "Fail";
	                    Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
	                            driver, test, TakeScreenshot);
	                }
	            }
	        } catch (Exception e) {
	            System.out.println(testCaseno + " " + testCaseDescription + " --Unexpected error");

	            if (report.equalsIgnoreCase("TESTSTEP")) {
	                Status = "Fail";
	                Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application, driver,
	                        test, TakeScreenshot);

	            }
	        }
	    }
	}



