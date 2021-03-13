package framework;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class IsNotEditable {

    public static void isNotEditable(String viewPort, String functionality, String driverExecute, String testCaseno,
                                   String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
                                   WebDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
                                   String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
            throws IOException, ParseException, InterruptedException {
        String Status = null;
        try {
            Thread.sleep(1000);
            if (viewPort.equalsIgnoreCase("DESKTOP")) {
                String Windowid = driver.getWindowHandle();
                driver.switchTo().window(Windowid);
            }
            String value = webelement.getAttribute("disabled");
            if(value==null){
                webelement.click();
                webelement.sendKeys("isEditable");
                webelement.sendKeys("123456");
                value = webelement.getAttribute("value") + webelement.getText();
                if (value.contains("isEditable") || value.contains("123456")) {
                    webelement.clear();
                    System.out.println(testCaseno + " " + testCaseDescription + " -- Failed");
                    if (report.equalsIgnoreCase("TESTSTEP")) {
                        Status = "Fail";
                        Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
                                driver, test, TakeScreenshot);

                    }
                } else {
                    System.out.println(testCaseno + " " + testCaseDescription + " -- Passed");

                    if (report.equalsIgnoreCase("TESTSTEP")) {
                        Status = "Pass";
                        Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
                                driver, test, TakeScreenshot);
                    }else {
                        test.fail(testCaseno + " " + testCaseDescription);
                    }
                }
            }else {
                if(value.equals("true")){
                    System.out.println(testCaseno + " " + testCaseDescription + " --Passed");
                    if (report.equalsIgnoreCase("TESTSTEP")) {
                        Status = "Pass";
                        Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
                                driver, test, TakeScreenshot);
                    }
                    test.pass(testCaseno + " " + testCaseDescription);
                }else{
                    if (report.equalsIgnoreCase("TESTSTEP")) {
                        Status = "Fail";
                        Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
                                driver, test, TakeScreenshot);

                    }
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
    public static void isNotEditable(String viewPort, String functionality, String driverExecute, String testCaseno,
                                   String testCaseDescription, String testCaseExecute, MobileElement element, String testData, String action,
                                   AppiumDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
                                   String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test)
            throws IOException, ParseException, InterruptedException {
        String Status = null;
        try {
            Thread.sleep(1000);
            element.click();
            element.sendKeys("isEditable");
            element.sendKeys("123456");
            String value = element.getText();
            if (!value.contains("isEditable") || !value.contains("123456")) {
                System.out.println(testCaseno + " " + testCaseDescription + " --Failed");

                if (report.equalsIgnoreCase("TESTSTEP")) {
                    Status = "Fail";
                    Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status, application,
                            driver, test, TakeScreenshot);

                }
                element.clear();
            } else {
                System.out.println(testCaseno + " " + testCaseDescription + " --Passed");


                if (report.equalsIgnoreCase("TESTSTEP")) {
                    Status = "Pass";
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
