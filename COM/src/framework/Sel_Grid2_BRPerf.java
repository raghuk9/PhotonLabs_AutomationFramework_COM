package framework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by maretska on 3/31/16.
 */
public class Sel_Grid2_BRPerf {
	private static final String HUB_URL = "http://50.19.207.2:4444/wd/hub";
	private WebDriver driver = null;
	private JavascriptExecutor jse;
	private Dimension dimension;
	private DesiredCapabilities caps;

	@BeforeTest(alwaysRun = true)
	@Parameters({ "platform", "browser", "url" })
	public void setup(String platform, String browser, String url) throws MalformedURLException, InterruptedException {
		caps = new DesiredCapabilities();
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}
		if (browser.equalsIgnoreCase("Chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browser.equalsIgnoreCase("Firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		if (browser.equalsIgnoreCase("IE")) {
			caps = DesiredCapabilities.internetExplorer();
		}
		if (browser.equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		}
		driver = new RemoteWebDriver(new URL(HUB_URL), caps);
		dimension = new Dimension(480, 800);
		driver.manage().window().setSize(dimension);
		jse = (JavascriptExecutor) driver;
		long id = Thread.currentThread().getId();
//		System.out.println("Thread id is: " + id);
		driver.get(url);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Object val = js.executeScript(""
				+ "try{window.performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {};"
				+ "return(parseInt(window.performance.timing.domContentLoadedEventEnd)-parseInt(window.performance.timing.fetchStart));}catch(e){alert(e);}");
		String s = val.toString();

		Object val1 = js.executeScript(""
				+ "try{window.performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {};"
				+ "return(parseInt(window.performance.timing.domComplete)-parseInt(window.performance.timing.navigationStart));}catch(e){alert(e);}");
		String s1 = val1.toString();
		System.out.print("Dom Load + Page Load " + s + " * " + s1);

		driver.get(url);

		val = js.executeScript(""
				+ "try{window.performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {};"
				+ "return(parseInt(window.performance.timing.domContentLoadedEventEnd)-parseInt(window.performance.timing.fetchStart));}catch(e){alert(e);}");
		s = val.toString();

		val1 = js.executeScript(""
				+ "try{window.performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {};"
				+ "return(parseInt(window.performance.timing.domComplete)-parseInt(window.performance.timing.navigationStart));}catch(e){alert(e);}");
		s1 = val1.toString();
//		System.out.print(" " + s + " * " + s1);
//		System.out.println();

	}

	@Test
	public void test() throws InterruptedException {

		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}
}