package framework;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollAndroid {

	@SuppressWarnings("rawtypes")
	public static void scrollAndroid(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement element, String testData, String action,
			AppiumDriver driver, String oldValue, String DriverToInvoke, String TakeScreenshot, int j, String report,
			String application, String startTm, String endTm, Set<String> windowhandles, ExtentTest test) {
		try {

			int Y = driver.manage().window().getSize().getHeight();
			int X = driver.manage().window().getSize().getWidth();

			TouchAction action1 = new TouchAction((PerformsTouchActions) driver);
			action1.press(PointOption.point(X / 2, (Y / 4) * 3))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(X / 2, (Y / 4) * 1)).release().perform();

			// extent report for status pass
			test.pass(testCaseno + " " + testCaseDescription);
		} catch (Exception e) {
			System.out.println(e.getMessage());

			// extent report for status fail
			test.fail(testCaseno + " " + testCaseDescription + " ERROR: -- " + e.getMessage());
		}
	}

}
