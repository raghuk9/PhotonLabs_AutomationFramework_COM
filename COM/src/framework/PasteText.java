package framework;



import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasteText {

	public void pasteText(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles)
			throws InterruptedException {
		try {
			Thread.sleep(500);
			if ( testData.toUpperCase().equals("WINDOWS")) {
				webelement.sendKeys(Keys.chord(Keys.CONTROL, "v"));			
				System.out.println(testCaseno+" "+testCaseDescription+" --Pass");
			}
			else {
				webelement.sendKeys(Keys.chord(Keys.COMMAND, "v"));			
				System.out.println(testCaseno+" "+testCaseDescription+" --Pass");
			}
		} catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
			
			System.out.println(e.getMessage());
			
		
	}
	}
}
