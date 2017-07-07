package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Set;

public class IosNativeScroll {

	public void iosNativeScroll(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles)
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	    HashMap<String, String> scrollObject = new HashMap<String, String>();
	  
	  //  scrollObject.put("direction", "down");
	
	
	    scrollObject.put("element", ((RemoteWebElement) webelement).getId());
	   
	  //  js.executeScript("mobile: scrollTo", scrollObject);
	    js.executeScript("mobile: scroll", scrollObject);
	    
		
	}

}
