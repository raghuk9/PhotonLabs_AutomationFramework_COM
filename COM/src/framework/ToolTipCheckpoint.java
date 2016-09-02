package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolTipCheckpoint {
	
	public void toolTipCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		String Status=null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			
            String toolTip=webelement.getAttribute("title");
			if(toolTip.equals(testData))
			{
				System.out.println(testCaseno+" "+testCaseDescription+" Tool tip is getting displaying correctly");
				Status = "Pass";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
			else
			{
				Status = "Fail";
                System.out.println(testCaseno+" "+testCaseDescription+" Tool tip not matched");
                Results.results(testCaseno, testCaseDescription, Status,
    					viewPort, application, startTm, endTm, driver);
			}

		} catch (Exception e) {
            System.out.println(testCaseno+" "+testCaseDescription+" Not able to capture the tool tip");
			Status = "Fail";
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);

		}
		
	}

}
