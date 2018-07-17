package framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("unused")
public class Main {

	private static final String ACTION_SIZE_AND_LOCATION = "SizeAndLocation";
	private static final String ACTION_UI_TEST = "UiTest";
	private static final String ROWS_IN_GRID = "RowsInGrid";
	private static final String APPIUM = "APPIUM";
	private static final String APPAND = "APPAND";
	private static final String APPIOS = "APPIOS";
	private static final String YES_VALUE = "YES";
	private static final String Screenshot_ALL = "ALL";
	private static final String Screenshot_FAIL = "FAIL";

	// variable for extent reports
	private static ExtentReports extent;
	private static ExtentTest test;
	public static String driverName;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException {
		Sheet functionalitysheet = null;
		Set<String> windowhandles = null;
		int excelFuncRowCount = 0;
		String startTm = null;
		String functionalitySheetName = null;
		String endTm = null;
		WebElement webelement = null;
		MobileElement mobileelement = null;
		int counter = 0;
		String oldValue = null;
		WebDriver driver = null;

		try {
			File ff = new File("DriverSheet.ods");
			String path = ff.getAbsolutePath();
			Sheet sheet = SpreadSheet.createFromFile(new File(path.trim())).getSheet(0);
			MutableCell viewPortValue = null;
			MutableCell executeValue = null;
			MutableCell driverValue = null;
			MutableCell functionalityValue = null;
			MutableCell testCasenoValue = null;
			MutableCell testCaseDescriptionValue = null;
			MutableCell testCaseExecuteValue = null;
			MutableCell actionValue = null;
			MutableCell objectIdentifierValue = null;
			MutableCell testDataValue = null;
			MutableCell objectSheetNameValue = null;
			MutableCell objectIdentifierTypeValue = null;
			MutableCell reportvalue = null;
			MutableCell applicationValue = null;
			MutableCell firefoxPathValue = null;

			// To support uiautomator2 and launching installing apk.
			MutableCell AppLocationValue = null;
			MutableCell AppPackageValue = null;
			MutableCell AppActivityValue = null;
			MutableCell DeviceIdValue = null;
			// To support ALL/ Fail Test Case Screenshot
			MutableCell TakeScreenshotValue = null;

			java.util.Date startTime = null;
			String Status = null;
			String viewPort = null;
			String DriverToInvoke = null;
			String functionality = null;
			String driverExecute = null;
			String screenShot = null;
			String testCaseno = null;
			String testCaseDescription = null;
			String testCaseExecute = null;
			String ObjectIdentifier = null;
			String testData = null;
			String action = null;
			AppiumDriver appiumdriver = null;
			String ObjectSheetName = null;
			String ObjectIdentifierType = null;
			String report = null;
			String application = null;
			String firefoxPath = null;

			// To support uiautomator2 and launching installing apk.
			String AppLocation = null;
			String AppPackage = null;
			String AppActivity = null;
			String DeviceId = null;
			// To support ALL/ Fail Test Case Screenshot
			String TakeScreenshot = null;

			// creating instance for extent reports
			extent = ExtentManager.createInstance("extentReport.html");
			for (int i = 1; i < sheet.getRowCount(); i++) {
				System.out.println("Started reading the Driversheet sheet......");
				viewPortValue = sheet.getCellAt(0, i);
				// remove
				System.out.println("++++++++++++++++_________" + viewPortValue);
				viewPort = viewPortValue.getTextValue();
				System.out.println(viewPortValue);
				if ("END".equals(viewPort.trim())) {
					System.out.println("Exiting outer loop");
					break;
				}
				driverValue = sheet.getCellAt(1, i);
				applicationValue = sheet.getCellAt(2, i);
				functionalityValue = sheet.getCellAt(3, i);
				reportvalue = sheet.getCellAt(4, i);
				executeValue = sheet.getCellAt(5, i);
				// New columns in DriverSheet.ods
				DeviceIdValue = sheet.getCellAt(6, i);
				AppLocationValue = sheet.getCellAt(7, i);
				AppPackageValue = sheet.getCellAt(8, i);
				AppActivityValue = sheet.getCellAt(9, i);
				TakeScreenshotValue = sheet.getCellAt(10, i);
				// ---------------
				DriverToInvoke = driverValue.getTextValue();
				functionality = functionalityValue.getTextValue();
				driverExecute = executeValue.getTextValue();
				report = reportvalue.getTextValue();
				application = applicationValue.getTextValue();

				DeviceId = DeviceIdValue.getTextValue();
				AppLocation = AppLocationValue.getTextValue();
				AppPackage = AppPackageValue.getTextValue();
				AppActivity = AppActivityValue.getTextValue();
				TakeScreenshot = TakeScreenshotValue.getTextValue();

				String sheetname = viewPort + "Sheet";
				System.out.println("sheetname = " + sheetname);
				if (YES_VALUE.equalsIgnoreCase(driverExecute)) {
					// Report_Header reportHeader = new Report_Header();
					// reportHeader.report_Header(viewPort, application);
					System.out.println("Trying to open " + DriverToInvoke);
					if (APPIOS.equalsIgnoreCase(DriverToInvoke.trim())) {
						appiumdriver = Selecting_Device.selectappium();
					} else if (APPAND.equalsIgnoreCase(DriverToInvoke.trim())) {
						//appiumdriver = Selecting_Device.selectappiumand();
						appiumdriver = Selecting_Device.selectappiumand(DeviceId,AppLocation,AppPackage,AppActivity);
					} else {
						driver = Selecting_Device.selectdevice(DriverToInvoke);
					}
					System.out.println(DriverToInvoke + " Opened");
					if (!APPIUM.equalsIgnoreCase(viewPort)) {
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}
					functionalitySheetName = functionality;
					File testCaseFile = new File(functionalitySheetName);
					functionality = testCaseFile.getAbsolutePath();
					if (!testCaseFile.exists()) {
						System.out.println("Please create a spreadsheet with name '" + functionalitySheetName
								+ "' in path " + functionality + " Workbook name is case sensitive");
					}
					String usedRangeInnerSheet = null;
					try {
						System.out.println(functionality);
						functionalitysheet = SpreadSheet.createFromFile(new File(functionality)).getSheet(sheetname);
						System.out.println("functionalitysheet = " + functionalitysheet.getName());
					} catch (Exception e) {
						System.out.println("Please create a workbook with name '" + sheetname + "' in sheet "
								+ functionalitySheetName + " Sheetname is case sensitive");
						e.printStackTrace();
					}

					// creating test for extent report
					test = extent.createTest(application);

					for (int j = 1; j < functionalitysheet.getRowCount(); j++) {
						if ("END".equals(functionalitysheet.getCellAt(0, j).getTextValue().trim())) {
							System.out.println("Exiting inner loop");
							break;
						}
						actionValue = functionalitysheet.getCellAt(2, j);
						action = actionValue.getTextValue();
						testCaseDescriptionValue = functionalitysheet.getCellAt(1, j);
						objectIdentifierTypeValue = functionalitysheet.getCellAt(3, j);
						objectIdentifierValue = functionalitysheet.getCellAt(4, j);
						testDataValue = functionalitysheet.getCellAt(5, j);
						objectSheetNameValue = functionalitysheet.getCellAt(6, j);
						testCaseExecuteValue = functionalitysheet.getCellAt(7, j);
						testCaseno = functionalitysheet.getCellAt(0, j).getTextValue().trim();
						testData = testDataValue.getTextValue();
						ObjectSheetName = objectSheetNameValue.getTextValue();
						testCaseDescription = testCaseDescriptionValue.getTextValue();
						ObjectIdentifierType = objectIdentifierTypeValue.getTextValue();
						testCaseExecute = testCaseExecuteValue.getTextValue();
						ObjectIdentifier = objectIdentifierValue.getTextValue();
						DateFormat dd = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
						if (YES_VALUE.equalsIgnoreCase(testCaseExecute)) {
							if (ObjectIdentifier.length() != 0 && !ROWS_IN_GRID.equalsIgnoreCase(action)) {
								System.out.println("Came to the find element section");
								if (DriverToInvoke.toUpperCase().equals(APPIOS)
										|| DriverToInvoke.toUpperCase().equals(APPAND)) {
									mobileelement = FindElement.find_Element(ObjectIdentifierType, ObjectIdentifier,
											appiumdriver, viewPort, testCaseno, testCaseDescription, application,
											startTm, endTm, test);
								} else {
									webelement = FindElement.find_Element(ObjectIdentifierType, ObjectIdentifier,
											driver, viewPort, testCaseno, testCaseDescription, application, startTm,
											endTm, test);
								}
							}
							if (ACTION_UI_TEST.equals(action)) {
								UiTest.uiTest(functionality, webelement, driver, ObjectSheetName, testCaseno,
										testCaseDescription, j, report, viewPort,DriverToInvoke, TakeScreenshot, application, startTm, endTm,
										ObjectIdentifier, test);
							} else if (action.equals("Click")) {
								if (DriverToInvoke.toUpperCase().equals(APPIOS)
										|| DriverToInvoke.toUpperCase().equals(APPAND)) {
									windowhandles = Click.click(viewPort, functionality, driverExecute, testCaseno,
											testCaseDescription, testCaseExecute, mobileelement, testData, action,
											appiumdriver, oldValue,DriverToInvoke, TakeScreenshot,j, report, application, startTm, endTm,
											windowhandles, test);
								} else {
									windowhandles = Click.click(viewPort, functionality, driverExecute, testCaseno,
											testCaseDescription, testCaseExecute, webelement, testData, action, driver,
											oldValue,DriverToInvoke, TakeScreenshot, j, report, application, startTm, endTm, windowhandles, test);
								}
							} else if (action.equals("StartTime")) {
								startTime = (java.util.Date) StartTime.startTime();
								startTm = dd.format(startTime);
								java.util.Date verynewdate = new java.util.Date();
								startTm = dd.format(verynewdate);
								Status = "Pass";
								// Results.results(testCaseno, testCaseDescription, Status, viewPort,
								// application, startTm,
								// endTm, driver);
								Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
										application, driver, test, TakeScreenshot);

								// extent report for status pass
								test.pass(testCaseno + " " + testCaseDescription);

							} else if (action.equals("EndTime")) {
								java.util.Date endTime = (java.util.Date) EndTime.endTime();
								endTm = dd.format(endTime);
								Status = "Pass";
								Results.results(viewPort, DriverToInvoke, testCaseno, testCaseDescription, Status,
										application, driver, test, TakeScreenshot);

								// extent report for status pass
								test.pass(testCaseno + " " + testCaseDescription);

								endTm = null;
							} else if (action.equals("OldValueCapture")) {
								OldValueCapture o = new OldValueCapture();
								if (DriverToInvoke.toUpperCase().equals(APPIOS)
										|| DriverToInvoke.toUpperCase().equals(APPAND)) {
									oldValue = o.oldValueCapture(mobileelement, driver, startTm);
								} else {
									oldValue = o.oldValueCapture(webelement, driver, startTm);
								}
							} else if (action.equals(ROWS_IN_GRID)) {
								RowsInGrid.rowsInGrid(viewPort, functionality, driverExecute, testCaseno,
										testCaseDescription, testCaseExecute, webelement, testData, action, driver,
										oldValue,DriverToInvoke,  TakeScreenshot, j, report, application, startTm, endTm, ObjectIdentifier, test);
							} else if (ACTION_SIZE_AND_LOCATION.equals(action)) {
								
								SizeAndLocation.sizeAndLocation( viewPort,  functionality,  driverExecute,
										 testCaseno,  testCaseDescription, testCaseExecute,   webelement,
										 testData,  action,  driver,  oldValue, DriverToInvoke,  TakeScreenshot, j,  report,  application,
										 startTm,  endTm,  windowhandles,  ObjectSheetName,  ObjectIdentifier,  test);
							} else {
								//
								
								//
								String Classname = "framework.";
								Class newclass = Class.forName(Classname.concat(action));
								Object object = newclass.newInstance();
								Class[] par = new Class[20];
								par[0] = String.class;
								par[1] = String.class;
								par[2] = String.class;
								par[3] = String.class;
								par[4] = String.class;
								par[5] = String.class;
								par[7] = String.class;
								par[8] = String.class;
								par[9] = String.class;
								par[10] = String.class;
								par[11] = String.class;
								par[12] = String.class;
								par[13] = Integer.TYPE;
								par[14] = String.class;
								par[15] = String.class;
								par[16] = String.class;
								par[17] = String.class;
								par[18] = Set.class;
								par[19] = ExtentTest.class;
								if (DriverToInvoke.toUpperCase().equals(APPIOS)
										|| DriverToInvoke.toUpperCase().equals(APPAND)) {
									par[6] = MobileElement.class;
									par[9] = AppiumDriver.class;
								} else {
									par[6] = WebElement.class;
									par[9] = WebDriver.class;
								}
								// This is to convert the first character to the
								// small letter to follow the naming conventions
								action = ConvertingToSmallLetter.convertingToSmallLetter(action);
								Method method = newclass.getMethod(action, par);
								if (DriverToInvoke.toUpperCase().equals(APPIOS)
										|| DriverToInvoke.toUpperCase().equals(APPAND)) {
									method.invoke(object, viewPort, functionality, driverExecute, testCaseno,
											testCaseDescription, testCaseExecute, mobileelement, testData, action,
											appiumdriver, oldValue, DriverToInvoke, TakeScreenshot,j, report, application, startTm, endTm,
											windowhandles, test);
								} else {
									method.invoke(object, viewPort, functionality, driverExecute, testCaseno,
											testCaseDescription, testCaseExecute, webelement, testData, action, driver,
											oldValue,DriverToInvoke, TakeScreenshot, j, report, application, startTm, endTm, windowhandles, test);
								}
							}
						}
					}
					// This is to close the web driver to proceed for the
					// another execution
					System.out.println("Closing x browser");
					driver.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured at Main.java");
			e.printStackTrace();
		} finally {
			System.out.println("In main finally about to quit");

			// flushing the report to extent
			extent.flush();

			if (driver != null) {
				driver.quit();
			}
			System.exit(0);
		}
	}
}