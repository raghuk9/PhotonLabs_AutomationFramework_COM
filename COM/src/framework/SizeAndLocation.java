package framework;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Set;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SizeAndLocation {

	private static final String DEVICE_DESKTOP = "Desktop";
	private static final String DEVICE_TABLET = "Tablet";
	private static final String DEVICE_MOBILE = "Mobile";
	private static final String STATUS_FAIL = "Fail";
	private static final String STATUS_PASS = "Pass";
	private static final String YES_VALUE = "YES";

	public static Set<String> sizeAndLocation(String viewPort, String functionality, String driverExecute,
			String testCaseno, String testCaseDescription, String testCaseExecute, WebElement webelement,
			String testData, String action, WebDriver driver, String oldValue, int j, String report, String application,
			String startTm, String endTm, Set<String> windowhandles, String ObjectSheetName, String objectIdentifier)
			throws IOException, ParseException, Exception {
		String Status = null;
		String Windowid = null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			String text = webelement.getText();
			System.out.println("the text is" + text);
			Dimension dimesion = webelement.getSize();
			System.out.println("Size : Width : " + dimesion.width);
			System.out.println("Size : Height : " + dimesion.height);
			Point point = webelement.getLocation();
			System.out.println("Location: X position : " + point.x);
			System.out.println("Location: Y position : " + point.y);
			System.out.println(ObjectSheetName);
			System.out.println("functionality in sizeandlocation = " + functionality);
			System.out.println("viewport in sizeandlocation = " + viewPort);
			Sheet objectSheet = SpreadSheet.createFromFile(new File(functionality)).getSheet(ObjectSheetName);
			for (int i = 1; i < objectSheet.getRowCount(); i++) {
				if ("END".equals(objectSheet.getCellAt(0, i).getTextValue().trim())) {
					System.out.println("Exiting sizeandlocation inner loop");
					break;
				}
				String ObjXpath = objectSheet.getCellAt(2, i).getTextValue();
				if (DEVICE_DESKTOP.equalsIgnoreCase(viewPort)
						&& YES_VALUE.equalsIgnoreCase(objectSheet.getCellAt(3, i).getTextValue())
						&& (ObjXpath.length() != 0) && (ObjXpath.equals(objectIdentifier))) {
					deskTopSuccessFailureResult(viewPort, testCaseno, testCaseDescription, webelement, driver,
							application, startTm, endTm, dimesion, point, objectSheet, i);
				} else if (DEVICE_TABLET.equalsIgnoreCase(viewPort)
						&& YES_VALUE.equalsIgnoreCase(objectSheet.getCellAt(8, i).getTextValue())
						&& (ObjXpath.length() != 0) && (ObjXpath.equals(objectIdentifier))) {
					 tabletSuccessFailureResult(viewPort, testCaseno,
					 testCaseDescription, webelement, driver,
					 application, startTm, endTm, dimesion, point,
					 objectSheet, i);
				} else if (DEVICE_MOBILE.equalsIgnoreCase(viewPort)
						&& YES_VALUE.equalsIgnoreCase(objectSheet.getCellAt(13, i).getTextValue())
						&& (ObjXpath.length() != 0) && (ObjXpath.equals(objectIdentifier))) {
					mobileSuccessFailureResult(viewPort, testCaseno, testCaseDescription, webelement, driver,
							application, startTm, endTm, dimesion, point, objectSheet, i);
				}
				// else if (i == objectSheet.getRowCount()) {
				// System.out.println("Object not found in the object sheet");
				// System.out.println(testCaseDescription + "--FAIL");
				// Status = "Fail";
				// Results.results(testCaseno, testCaseDescription, Status,
				// viewPort, application, startTm, endTm,
				// driver);
				// }
			}
			// end of code to read from WagHomePage sheet
			if (!"APPIUM".equalsIgnoreCase(viewPort)) {
				windowhandles = driver.getWindowHandles();
			}
			System.out.println(testCaseno + " " + testCaseDescription);
			// if ("TESTSTEP".equalsIgnoreCase(report)) {
			// Status = "Pass";
			// Results.results(testCaseno, testCaseDescription, Status,
			// viewPort, application, startTm, endTm, driver);
			// }
		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --ERROR");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = STATUS_FAIL;
				try {
					Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm,
							driver);
				} catch (Exception ex) {
					System.out.println("Exception occured at SizeAndLocation whille calling Results.results");
					ex.printStackTrace();
				}
			}
		}
		return windowhandles;
	}

	private static void deskTopSuccessFailureResult(String viewPort, String testCaseno, String testCaseDescription,
			WebElement webelement, WebDriver driver, String application, String startTm, String endTm,
			Dimension dimesion, Point point, Sheet objectSheet, int i) throws IOException, ParseException {
		String status = STATUS_FAIL;
		int desktopXcoordinate = Integer.parseInt(objectSheet.getCellAt(4, i).getTextValue());
		int desktopYCoordinate = Integer.parseInt(objectSheet.getCellAt(5, i).getTextValue());
		int desktopWidth = Integer.parseInt(objectSheet.getCellAt(6, i).getTextValue());
		int desktopHeight = Integer.parseInt(objectSheet.getCellAt(7, i).getTextValue());
		printValuesFromSheet(desktopXcoordinate, desktopYCoordinate, desktopWidth, desktopHeight, DEVICE_DESKTOP);
		if (webelement.isDisplayed() && desktopXcoordinate == point.x && desktopYCoordinate == point.y
				&& desktopWidth == dimesion.width && desktopHeight == dimesion.height) {
			System.out.println(testCaseDescription + "--PASS");
			status = STATUS_PASS;
			Results.results(testCaseno, testCaseDescription, status, viewPort, application, startTm, endTm, driver);
		} else {
			System.out.println(testCaseDescription + "--FAIL");
			status = STATUS_FAIL;
			Results.results(testCaseno, testCaseDescription, status, viewPort, application, startTm, endTm, driver);
		}
	}

	private static void tabletSuccessFailureResult(String viewPort, String testCaseno, String testCaseDescription,
			WebElement webelement, WebDriver driver, String application, String startTm, String endTm,
			Dimension dimesion, Point point, Sheet objectSheet, int i) throws IOException, ParseException {
		String status;
		int tabletXcoordinate = Integer.parseInt(objectSheet.getCellAt(9, i).getTextValue());
		int tabletYCoordinate = Integer.parseInt(objectSheet.getCellAt(10, i).getTextValue());
		int tabletWidth = Integer.parseInt(objectSheet.getCellAt(11, i).getTextValue());
		int tabletHeight = Integer.parseInt(objectSheet.getCellAt(12, i).getTextValue());
		printValuesFromSheet(tabletXcoordinate, tabletYCoordinate, tabletWidth, tabletHeight, DEVICE_TABLET);
		if (webelement.isDisplayed() && tabletXcoordinate == point.x && tabletYCoordinate == point.y
				&& tabletWidth == dimesion.width && tabletHeight == dimesion.height) {
			System.out.println(testCaseDescription + "--PASS");
			status = STATUS_PASS;
			Results.results(testCaseno, testCaseDescription, status, viewPort, application, startTm, endTm, driver);
		} else {
			System.out.println(testCaseDescription + "--FAIL");
			status = STATUS_FAIL;
			Results.results(testCaseno, testCaseDescription, status, viewPort, application, startTm, endTm, driver);
		}
	}

	private static void mobileSuccessFailureResult(String viewPort, String testCaseno, String testCaseDescription,
			WebElement webelement, WebDriver driver, String application, String startTm, String endTm,
			Dimension dimesion, Point point, Sheet objectSheet, int i) throws IOException, ParseException {
		String Status;
		int mobileXcoordinate = Integer.parseInt(objectSheet.getCellAt(14, i).getTextValue());
		int mobileYCoordinate = Integer.parseInt(objectSheet.getCellAt(15, i).getTextValue());
		int mobileWidth = Integer.parseInt(objectSheet.getCellAt(16, i).getTextValue());
		int mobileHeight = Integer.parseInt(objectSheet.getCellAt(17, i).getTextValue());
		printValuesFromSheet(mobileXcoordinate, mobileYCoordinate, mobileWidth, mobileHeight, DEVICE_MOBILE);
		if (webelement.isDisplayed() && mobileXcoordinate == point.x && mobileYCoordinate == point.y
				&& mobileWidth == dimesion.width && mobileHeight == dimesion.height) {
			System.out.println(testCaseDescription + "--PASS");
			Status = STATUS_PASS;
			Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm, driver);
		} else {
			System.out.println(testCaseDescription + "--FAIL");
			Status = STATUS_FAIL;
			Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm, driver);
		}
	}

	private static void printValuesFromSheet(int xCoordinate, int yCoordinate, int width, int height,
			String deviceType) {
		System.out.println("DeviceType for testing = " + deviceType);
		System.out.println("xCoordinate = " + xCoordinate);
		System.out.println("yCoordinate = " + yCoordinate);
		System.out.println("width = " + width);
		System.out.println("height = " + height);
	}

	public static Set<String> sizeAndLocation(String viewPort, String functionality, String driverExecute,
			String testCaseno, String testCaseDescription, String testCaseExecute, MobileElement element,
			String testData, String action, AppiumDriver driver, String oldValue, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles)
			throws IOException, ParseException {
		String Status = null;
		String Windowid = null;
		try {
			Thread.sleep(1000);
			if (!"APPIUM".equalsIgnoreCase(viewPort)) {
				Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				System.out.println(driver.getWindowHandle());
			}
			Dimension dimesions = element.getSize();
			System.out.println("Size : Width : " + dimesions.width);
			System.out.println("Size : Height : " + dimesions.height);
			Point point = element.getLocation();
			System.out.println("Location: X position : " + point.x);
			System.out.println("Location: Y position : " + point.y);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, Double> coords = new HashMap<String, Double>();
			coords.put("x", (double) point.x); // in pixels from left
			coords.put("y", (double) point.y); // in pixels from top
			System.out.println(coords);
			js.executeScript("mobile: tap", coords);
			System.out.println("5");
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				windowhandles = driver.getWindowHandles();
			}
			System.out.println(testCaseno + " " + testCaseDescription);
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = STATUS_PASS;
				Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm, driver);
			}
		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --ERROR");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = STATUS_FAIL;
				try {
					Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm,
							driver);
				} catch (Exception ex) {
					System.out.println("Exception occured at SizeAndLocation whille calling Results.results");
					ex.printStackTrace();
				}
			}
		}
		return windowhandles;
	}
}
