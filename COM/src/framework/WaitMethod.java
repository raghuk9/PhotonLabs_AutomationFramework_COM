package framework;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitMethod {

	public void waitMethod(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
			Set<String> windowhandles) throws InterruptedException {
		int value = Integer.parseInt(testData);
		Thread.sleep(value);
	}

}
