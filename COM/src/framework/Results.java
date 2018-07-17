package framework;


import org.apache.commons.lang3.time.DurationFormatUtils;
import org.jopendocument.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import framework.util.Screenshot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Results {
	private static final String STATUS_PASS = "Pass";
	private static final String STATUS_FAIL = "Fail";
	private static int successCount = 0;
	private static int failureCount = 0;
	private static String screenpath = null;
	private FileWriter screenfw = null;
	private File file = null;
	BufferedWriter screenbw = null;
	static String imagePath;


	@SuppressWarnings({ "unused" })
	public static void results(String viewPort,String Driver, String testCaseNumber, String testCaseDescription, String status, 
			String application, WebDriver driver, ExtentTest test, String TakeScreenshot) throws IOException, ParseException, InterruptedException {
		String osname = System.getProperty("os.name").toLowerCase();
		String output = null;
		String newPath = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		File ff = new File("DriverSheet.ods");
		String path = ff.getAbsolutePath();
		if (osname.contains("win")) {
			newPath = path.substring(0, path.lastIndexOf("\\")).concat("\\");
		} else {
			newPath = path.substring(0, path.lastIndexOf("/")).concat("/");
		}
		if (STATUS_PASS.equals(status)) {
			imagePath=Screenshot.imagepath(viewPort,Driver,testCaseNumber, testCaseDescription, status, application,driver);
			
			if(TakeScreenshot.equalsIgnoreCase("All")) 
				test.pass(testCaseNumber + " " + testCaseDescription, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver, imagePath)).build());
	        
				//test.addScreenCaptureFromPath(imagePath);
			System.out.println("ALL ");
			

		}else if (STATUS_FAIL.equals(status)) {
			System.out.println("coming to fail section");
			// resultVO.setFailureCount(++failureCount);
			String fail = "FAIL";
			if (!"APPIUM".equalsIgnoreCase(viewPort)) {
				imagePath=Screenshot.imagepath(viewPort,Driver,testCaseNumber, testCaseDescription, status, application,driver);
				//test.info()
				test.fail(testCaseNumber + " " + testCaseDescription, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver, imagePath)).build());
				
			}
		}else test.pass(testCaseNumber + " " + testCaseDescription);

	}
	
}
