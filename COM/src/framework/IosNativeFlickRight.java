package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Set;

public class IosNativeFlickRight {

	public void iosNativeFlickRight(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j, String report,
			String application, String startTm, String endTm,Set<String> windowhandles) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("came to the ios flick");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "right");
		scrollObject.put("element", ((RemoteWebElement) webelement).getId());
		js.executeScript("mobile: scroll", scrollObject);
	}

}
