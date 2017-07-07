package framework;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;

public class FindElement {

	public static WebElement find_Element(String ObjectIdentifierType,
			String ObjectIdentifier, WebDriver driver, String viewPort,
			String testCaseno, String testCaseDescription, String application,
			String startTm, String endTm, ExtentTest test) throws IOException, ParseException {

		String Status = null;
		WebElement webelement = null;

		if (!viewPort.toUpperCase().equals("APPIUM")) {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
		}

		System.out.println("came to find element section");
		if (ObjectIdentifierType.toUpperCase().equals("XPATH")) {
			try {
				System.out.println(testCaseno
						+ " Trying to identify object using XPATH started...");
				webelement = driver.findElement(By.xpath(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of object using XPATH is done");
			} catch (Exception e) {
				
				//System.out.println(webelement);
				System.out.println(testCaseno
						+ " Identication of object using XPATH is failed!");
//				driver.close();

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}

		else if (ObjectIdentifierType.toUpperCase().equals("NAME")) {
			try {
				System.out.println("came to name sections");
				System.out.println(testCaseno
						+ " Trying to identify object using Name  started...");
				webelement = driver.findElement(By.name(ObjectIdentifier));
				System.out
						.println(testCaseno
								+ " Identification of object using Name selector is done");
			} catch (Exception e) {
				System.out
						.println(testCaseno
								+ " Identication of object using Name selctor is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}

		else if (ObjectIdentifierType.toUpperCase().equals("LINKTEXT")) {
			try {
				System.out.println("came to name sections");
				System.out
						.println(testCaseno
								+ " Trying to identify object using link text  started...");
				webelement = driver.findElement(By.linkText(ObjectIdentifier));
				System.out
						.println(testCaseno
								+ " Identification of object using linktext selector is done");
			} catch (Exception e) {
				System.out
						.println(testCaseno
								+ " Identication of object using linktext selctor is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}else if (ObjectIdentifierType.toUpperCase().equals("PARTIALLINKTEXT")) {
			try {
				System.out.println("mobile - came to PARTIALLINKTEXT sections");
				System.out
						.println(testCaseno
								+ " Trying to identify mobile object using PARTIALLINKTEXT text  started...");
				webelement = driver.findElement(By.partialLinkText(ObjectIdentifier));
				System.out
						.println(testCaseno
								+ " Identification of mobile object using PARTIALLINKTEXT selector is done");
			} catch (Exception e) {
				System.out
						.println(testCaseno
								+ " Identication of mobile object using PARTIALLINKTEXT selector is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}

		else if (ObjectIdentifierType.toUpperCase().equals("CSS")) {
			try {

				System.out
						.println(testCaseno
								+ " Trying to identify object using CSS selector started...");
				webelement = driver.findElement(By
						.cssSelector(ObjectIdentifier));
				System.out
						.println(testCaseno
								+ " Identification of object using CSS selector is done");
			} catch (Exception e) {
				System.out
						.println(testCaseno
								+ " Identication of object using css selctor is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("ID")) {
			try {
				System.out.println(testCaseno
						+ " Trying to identify object using ID started...");
				webelement = driver.findElement(By.id(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of object using ID is done");
			} catch (Exception e) {
				// Status = "Fail";
				System.out.println(testCaseno
						+ " Identication of object using ID is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("TAG")) {
			try {
				System.out.println(testCaseno
						+ " Trying to identify object using TAG started...");
				webelement = driver.findElement(By.tagName(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of object using TAG is done");
			} catch (Exception e) {
				// Status = "Fail";
				System.out.println(testCaseno
						+ " Identication of object using TAG is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("CLASS")) {
			try {
				System.out
						.println(testCaseno
								+ " Trying to identify object using CLASS name started...");
				webelement = driver.findElement(By.className(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of object using CLASS name is done");
			} catch (Exception e) {
				// Status = "Fail";
				System.out
						.println(testCaseno
								+ " Identication of object using CLASS name is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}

		return webelement;
	}

	public static MobileElement find_Element(String ObjectIdentifierType,
			String ObjectIdentifier, AppiumDriver driver, String viewPort,
			String testCaseno, String testCaseDescription, String application,
			String startTm, String endTm, ExtentTest test) throws IOException, ParseException {

		String Status = null;
		MobileElement webelement = null;

		if (!viewPort.toUpperCase().equals("APPIUM")) {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
		}

		System.out.println("mobile - came to find element section");
		if (ObjectIdentifierType.toUpperCase().equals("XPATH")) {
			try {
				System.out.println(testCaseno
						+ " Trying to identify mobile object using XPATH started...");
				webelement = (MobileElement) driver.findElement(By.xpath(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of mobile object using XPATH is done");
			} catch (Exception e) {
				
				System.out.println(testCaseno
						+ " Identication of object mobile using XPATH is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}

		else if (ObjectIdentifierType.toUpperCase().equals("NAME")) {
			try {
				System.out.println("mobile - came to name sections");
				System.out.println(testCaseno
						+ " Trying to identify mobie object using Name  started...");
				webelement = (MobileElement) driver.findElement(By.name(ObjectIdentifier));
				System.out
						.println(testCaseno
								+ " Identification of mobile object using Name selector is done");
			} catch (Exception e) {
				System.out
						.println(testCaseno
								+ " Identication of mobile object using Name selctor is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}

		else if (ObjectIdentifierType.toUpperCase().equals("LINKTEXT")) {
			try {
				System.out.println("mobile - came to linktext sections");
				System.out
						.println(testCaseno
								+ " Trying to identify mobile object using link text  started...");
				webelement = (MobileElement) driver.findElement(By.linkText(ObjectIdentifier));
				System.out
						.println(testCaseno
								+ " Identification of mobile object using linktext selector is done");
			} catch (Exception e) {
				System.out
						.println(testCaseno
								+ " Identication of mobile object using linktext selector is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}

		else if (ObjectIdentifierType.toUpperCase().equals("CSS")) {
			try {

				System.out
						.println(testCaseno
								+ " Trying to identify mobile object using CSS selector started...");
				webelement = (MobileElement) driver.findElement(By
						.cssSelector(ObjectIdentifier));
				System.out
						.println(testCaseno
								+ " Identification of mobile object using CSS selector is done");
			} catch (Exception e) {
				System.out
						.println(testCaseno
								+ " Identication of mobile object using css selctor is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Status = "Fail";
				//
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("ID")) {
			try {
				System.out.println(testCaseno
						+ " Trying to mobile identify object using ID started...");
				webelement = (MobileElement) driver.findElement(By.id(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of object using ID is done");
			} catch (Exception e) {
				// Status = "Fail";
				System.out.println(testCaseno
						+ " Identication of mobile object using ID is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("TAG")) {
			try {
				System.out.println(testCaseno
						+ " Trying to identify mobile object using TAG started...");
				webelement = (MobileElement) driver.findElement(By.tagName(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of mobile object using TAG is done");
			} catch (Exception e) {
				// Status = "Fail";
				System.out.println(testCaseno
						+ " Identication of mobile object using TAG is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		} else if (ObjectIdentifier.toUpperCase().equals("Class")) {
			try {
				System.out
						.println(testCaseno
								+ " Trying to identify mobile object using CLASS name started...");
				webelement = (MobileElement) driver.findElement(By.className(ObjectIdentifier));
				System.out.println(testCaseno
						+ " Identification of object mobile using CLASS name is done");
			} catch (Exception e) {
				// Status = "Fail";
				System.out
						.println(testCaseno
								+ " Identication of mobile object using CLASS name is failed!");

				// extent report for status fail
				test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm, driver);
			}
		}
		

		return webelement;
	}
}
