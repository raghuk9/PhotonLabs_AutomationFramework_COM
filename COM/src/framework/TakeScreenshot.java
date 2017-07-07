package framework;

import org.jopendocument.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class TakeScreenshot {
	@SuppressWarnings({ "unused", "deprecation", "resource" })
	public static void takeScreenshot(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
			Set<String> windowhandles) throws InterruptedException, IOException {
		Date date = new Date();
		long time = date.getTime();
		String ts = new Timestamp(time).toString();
		String str = "Screenshots/";
		StringBuilder sb = new StringBuilder();
		char c[] = ts.toCharArray();
		for (int i = 0; i < ts.length(); i++) {
			if (c[i] == ':') {
				sb.append('_');
			} else {
				sb.append(c[i]);
			}
		}
		str = str + testData + "_" + sb + ".jpg";
		System.out.println(str);
		TakesScreenshot t1 = (TakesScreenshot) driver;
		File f1 = t1.getScreenshotAs(OutputType.FILE);
		File f2 = new File(str);
		try {
			FileUtils.copyFile(f1, f2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}