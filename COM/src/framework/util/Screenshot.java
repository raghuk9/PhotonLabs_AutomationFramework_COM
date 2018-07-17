package framework.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static String capture(WebDriver driver, String screenshotFileName) throws IOException {

		File screens = new File("Screenshots");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File ScreenShotDirectory = new File("Screenshots");
		FileUtils.copyFile(scrFile, new File(screens +  File.separator + screenshotFileName ));
		File fileScreenshot = new File(screens + File.separator +  File.separator + screenshotFileName);
		return fileScreenshot.getAbsolutePath();
	
	}

	public static String imagepath(String viewPort,String Driver,String testCaseNumber, String testCaseDescription, String status,
			 String application, WebDriver driver) throws IOException, InterruptedException {

		
		String imageFileName = new StringBuilder(viewPort)
				.append("_")
				.append(Driver)
				.append("_")
				.append(testCaseNumber.replace(" ", "_"))
				.append("_")
				.append(testCaseDescription.replace(" ", "_"))
				.append("_")
				.append(status)
				.append("_")
				.append(currentDateTime())
				.append(".png")
				.toString();
			
return imageFileName;
	}
	
	public static String currentDateTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YY-HHmmss");    
		return sdf.format(date).toString();
		
	}

	
	
}
