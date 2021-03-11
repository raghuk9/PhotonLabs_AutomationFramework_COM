package framework;

import com.aventstack.extentreports.ExtentTest;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class UiTest {
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void uiTest(String functionality, WebElement webelement, WebDriver driver, String ObjectSheetName,
							  String testCaseno, String testCaseDescription, int j, String report, String viewPort,String DriverToInvoke, String TakeScreenshot, String application,
							  String startTm, String endTm, String ObjectIdentifier, ExtentTest test) throws IOException, ParseException, InterruptedException {
		String Status = null;
		String endTime = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			// System.out.println(ObjectSheetName);
			Sheet objectSheet = SpreadSheet.createFromFile(new File(functionality)).getSheet(ObjectSheetName);
			int ObjectSheetRowcount = objectSheet.getRowCount();
			for (int i = 1; i <= ObjectSheetRowcount; i++) {
				MutableCell ObjectIdValue = objectSheet.getCellAt(0, i);
				MutableCell ObjNameValue = objectSheet.getCellAt(1, i);
				MutableCell ObjXpathValue = objectSheet.getCellAt(2, i);
				MutableCell DesktopApplicabilityValue = objectSheet.getCellAt(3, i);
				MutableCell DesktopXcoordinateValue = objectSheet.getCellAt(4, i);
				MutableCell DesktopYCoordinateValue = objectSheet.getCellAt(5, i);
				MutableCell DesktopWidthValue = objectSheet.getCellAt(6, i);
				MutableCell DesktopHeightValue = objectSheet.getCellAt(7, i);
				MutableCell TabletApplicabilityValue = objectSheet.getCellAt(8, i);
				MutableCell TabletXCoordinateValue = objectSheet.getCellAt(9, i);
				MutableCell TabletYCoordinateValue = objectSheet.getCellAt(10, i);
				MutableCell TabletWidthValue = objectSheet.getCellAt(11, i);
				MutableCell TabletHeightValue = objectSheet.getCellAt(12, i);
				MutableCell MobileApplicabilityValue = objectSheet.getCellAt(13, i);
				MutableCell MobileXCoordinateValue = objectSheet.getCellAt(14, i);
				MutableCell MobileYCoordinateValue = objectSheet.getCellAt(15, i);
				MutableCell MobileWidthValue = objectSheet.getCellAt(16, i);
				MutableCell MobileHeightValue = objectSheet.getCellAt(17, i);
				String ObjectId = ObjectIdValue.getTextValue();
				String ObjName = ObjNameValue.getTextValue();
				String ObjXpath = ObjXpathValue.getTextValue();
				// Thread.sleep(5000);
				System.out.println("mobile x" + MobileXCoordinateValue);
				System.out.println("mobile y" + MobileYCoordinateValue);
				String DesktopApplicability = DesktopApplicabilityValue.getTextValue();
				if ((DesktopApplicability.toUpperCase().equals("YES")) && (ObjXpath.length() != 0)
						&& (ObjXpath.equals(ObjectIdentifier))) {
					String DesktopXcoordinate = DesktopXcoordinateValue.getTextValue();
					String DesktopYCoordinate = DesktopYCoordinateValue.getTextValue();
					String DesktopWidth = DesktopWidthValue.getTextValue();
					String DesktopHeight = DesktopHeightValue.getTextValue();

					if (webelement.isDisplayed()) {
						System.out.println(testCaseDescription + "--PASS");
						Status = "Pass";
						Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
								application, driver, test, TakeScreenshot);
						// extent report for status pass
						test.pass(testCaseno + " " + testCaseDescription);

						break;
						// System.out.println("camre here");
					} else {
						System.out.println(testCaseDescription + "--FAIL");
						Status = "Fail";
						Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
								application, driver, test, TakeScreenshot);

						// extent report for status fail
						test.fail(testCaseno + " " + testCaseDescription);
					}

				} else if (i == ObjectSheetRowcount) {
					System.out.println("Object not found in the object sheet");
					System.out.println(testCaseDescription + "--FAIL");
					Status = "Fail";
					Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
							application, driver, test, TakeScreenshot);

					// extent report for status fail
					test.fail(testCaseno + " " + testCaseDescription);

					// This need to be filled after getting the solution
					break;
				}

				// String TabletApplicability = TabletApplicabilityValue
				// .getTextValue();
				// if (TabletApplicability.equals("YES")) {
				// String TabletXCoordinate =
				// TabletXCoordinateValue.getTextValue();
				// String TabletYCoordinate =
				// TabletYCoordinateValue.getTextValue();
				// String TabletWidth = TabletWidthValue.getTextValue();
				// String TabletHeight = TabletHeightValue.getTextValue();
				// }
				//
				// String MobileApplicability = MobileApplicabilityValue
				// .getTextValue();
				// if (MobileApplicability.equals("YES")) {
				// String MobileXCoordinate =
				// MobileXCoordinateValue.getTextValue();
				// String MobileYCoordinate =
				// MobileYCoordinateValue.getTextValue();
				// String MobileWidth = MobileWidthValue.getTextValue();
				// String MobileHeight = MobileHeightValue.getTextValue();
				// }

			}
		} catch (Exception e) {
			// This is to execute when the object does not exist on the screen
			System.out.println(testCaseDescription + "--FAIL OBJ DOES NOT EXISTS ON THE SCREEN");
			Status = "Fail";
			Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
					application, driver, test, TakeScreenshot);
			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription+ " ERROR: -- " + e.getMessage());

		}
	}

}
