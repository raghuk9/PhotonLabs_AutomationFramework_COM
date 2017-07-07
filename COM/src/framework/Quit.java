package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Quit {

	public void quit(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws InterruptedException{
		
			driver.quit();
	}
}



