package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OldValueCapture {
	@SuppressWarnings("unused")
	public String oldValueCapture(WebElement webElement, WebDriver driver,
			String startTm) throws InterruptedException {
		String Status = null;
		try {

			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
			
			String Value = webElement.getText();
			System.out.println(Value);
			return Value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String oldValueCapture(MobileElement element, AppiumDriver driver,
			String startTm) throws InterruptedException {
		String Status = null;
		try {

			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
			
			String Value = element.getText();
			System.out.println(Value);
			return Value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
