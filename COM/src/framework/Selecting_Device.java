package framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.TestNG;
import org.testng.collections.Lists;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Selecting_Device {

	private static final String FIREFOX = "firefox";
	private static final String NODE_URL_WINDOWS_IE = "http://50.19.207.2:4444/wd/hub";
	private static final String NODE_URL_WINDOWS_CHROME = "http://50.19.207.2:4444/wd/hub";
	private static final String OS_WIN = "win";
	private static final String IE = "ie";
	private static final String CHROME = "chrome";
	private static final String NODE_URL_WINDOWS_FF = "http://172.16.99.6:5555/wd/hub";
	private static final String BROWSER_IE = "IE";
	private static final String GRID = "GRID";
	private static final String BROWSER_CHROME = "CHROME";
	private static final String BROWSER_SAFARI = "SAFARI";
	private static final String BROWSER_FIREFOX = "FIREFOX";
	@SuppressWarnings({})
	static AppiumDriver adriver = null;
	static AndroidDriver androiddriver = null;
		static WebDriver driver = null;
	static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static String browser;

	public static AppiumDriver selectappium() throws Exception {
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability(CapabilityType.VERSION, "7.1");
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		adriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
		return adriver;
	}

	public static AndroidDriver selectappiumand(String DeviceId,String AppLocation,String AppPackage,String AppActivity) throws Exception {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceId);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET,"true");
		
		capabilities.setCapability(MobileCapabilityType.APP,AppLocation);
		
		capabilities.setCapability("appPackage",AppPackage);
		capabilities.setCapability("appActivity",AppActivity);
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		androiddriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return androiddriver;
		}
	
	
	
public static AppiumDriver selectappiumAndroid() throws Exception {
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4");
		capabilities.setCapability(CapabilityType.PLATFORM, "MAC");
		adriver = (AppiumDriver) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
		return adriver;
	}

	public static WebDriver selectdevice(String driverType) throws Exception, MalformedURLException {
		String osname = System.getProperty("os.name").toLowerCase();
		System.out.println("osname = " + osname);
		WebDriver driver = null;
		capabilities = new DesiredCapabilities();
//		String platform = "";
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		Dimension dimension;
		if (BROWSER_FIREFOX.equalsIgnoreCase(driverType)) {
			if (osname.contains(OS_WIN)) {
				File ff = new File("Drivers/geckodriver.exe");
				String path = ff.getAbsolutePath();
				System.setProperty("webdriver.gecko.driver", path);
				return new FirefoxDriver();
			} else {
				File ff = new File("Drivers/geckodriver");
				String path = ff.getAbsolutePath();
				System.setProperty("webdriver.gecko.driver", path);
				return new FirefoxDriver();
			}

		} else if (driverType.toUpperCase().equals(BROWSER_SAFARI)) {
			return new SafariDriver();
		} else if (driverType.toUpperCase().equals(BROWSER_CHROME)) {
			if (osname.contains(OS_WIN)) {
				File ff = new File("Drivers/chromedriver.exe");
				String path = ff.getAbsolutePath();
				System.setProperty("webdriver.chrome.driver", path);
				return new ChromeDriver();
			} else {
				File chromePath = new File("Drivers/chromedriver");
				String path = chromePath.getAbsolutePath();
				System.setProperty("webdriver.chrome.driver", path);
				return new ChromeDriver();
			}
		} else if (driverType.toUpperCase().equals("APPCHROME")) {
			capabilities.setCapability("device", "Android");
			capabilities.setCapability("deviceName", "Android");
			capabilities.setCapability("version", "4.4");
			capabilities.setCapability("platform", "MAC");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", "chrome");
			try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
				System.out.println("mobile chrome opened");
				return driver;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (GRID.equalsIgnoreCase(driverType)) {
			// TODO as testng provide flexible way to implement grid do we need
			// this code
			TestNG testNG = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("testng.xml");
			testNG.setTestSuites(suites);
			testNG.run();

//			if (platform.equalsIgnoreCase("Windows")) {
//				desiredCapabilities.setPlatform(Platform.WINDOWS);
//			}
//			if (platform.equalsIgnoreCase("MAC")) {
//				desiredCapabilities.setPlatform(Platform.MAC);
//			}
			// TODO
//			browser = "Firefox";
//			if (browser.equalsIgnoreCase("Chrome")) {
//				desiredCapabilities = DesiredCapabilities.chrome();
//			}
//			if (browser.equalsIgnoreCase("Firefox")) {
//				desiredCapabilities = DesiredCapabilities.firefox();
//			}
//			if (browser.equalsIgnoreCase("IE")) {
//				desiredCapabilities = DesiredCapabilities.internetExplorer();
//			}
//			if (browser.equalsIgnoreCase("safari")) {
//				desiredCapabilities = DesiredCapabilities.safari();
//			}
//			driver = new RemoteWebDriver(new URL(NODE_URL_WINDOWS_CHROME), desiredCapabilities);
//			dimension = new Dimension(480, 800);
//			driver.manage().window().setSize(dimension);

		} else if (BROWSER_IE.equalsIgnoreCase(driverType)) {
			if (osname.contains(OS_WIN)) {
				File iePath = new File("Drivers/IEDriverServer.exe");
				String path = iePath.getAbsolutePath();
				System.setProperty("webdriver.ie.driver", path);
				return new InternetExplorerDriver();
			} else {
				System.out.println("IE driver cannot start on MAC or linux or unix machines sorry");

			}
		}
		return driver;
	}

	
	
	
	
	public static WebDriver selectdevice(String driverType,String AppLocation,String AppPackage,String AppActivity) throws Exception, MalformedURLException {
		String osname = System.getProperty("os.name").toLowerCase();
		System.out.println("osname = " + osname);
		WebDriver driver = null;
		capabilities = new DesiredCapabilities();
//		String platform = "";
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		Dimension dimension;
		if (BROWSER_FIREFOX.equalsIgnoreCase(driverType)) {
			if (osname.contains(OS_WIN)) {
				File ff = new File("Drivers/geckodriver.exe");
				String path = ff.getAbsolutePath();
				System.setProperty("webdriver.gecko.driver", path);
				return new FirefoxDriver();
			} else {
				File ff = new File("Drivers/geckodriver");
				String path = ff.getAbsolutePath();
				System.setProperty("webdriver.gecko.driver", path);
				return new FirefoxDriver();
			}

		} else if (driverType.toUpperCase().equals(BROWSER_SAFARI)) {
			return new SafariDriver();
		} else if (driverType.toUpperCase().equals(BROWSER_CHROME)) {
			if (osname.contains(OS_WIN)) {
				File ff = new File("Drivers/chromedriver.exe");
				String path = ff.getAbsolutePath();
				System.setProperty("webdriver.chrome.driver", path);
				return new ChromeDriver();
			} else {
				File chromePath = new File("Drivers/chromedriver");
				String path = chromePath.getAbsolutePath();
				System.setProperty("webdriver.chrome.driver", path);
				return new ChromeDriver();
			}
		} else if (driverType.toUpperCase().equals("APPCHROME")) {
			capabilities.setCapability("device", "Android");
			capabilities.setCapability("deviceName", "Android");
			capabilities.setCapability("version", "4.4");
			capabilities.setCapability("platform", "MAC");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", "chrome");
			try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
				System.out.println("mobile chrome opened");
				return driver;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (GRID.equalsIgnoreCase(driverType)) {
			// TODO as testng provide flexible way to implement grid do we need
			// this code
			TestNG testNG = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("testng.xml");
			testNG.setTestSuites(suites);
			testNG.run();

//			if (platform.equalsIgnoreCase("Windows")) {
//				desiredCapabilities.setPlatform(Platform.WINDOWS);
//			}
//			if (platform.equalsIgnoreCase("MAC")) {
//				desiredCapabilities.setPlatform(Platform.MAC);
//			}
			// TODO
//			browser = "Firefox";
//			if (browser.equalsIgnoreCase("Chrome")) {
//				desiredCapabilities = DesiredCapabilities.chrome();
//			}
//			if (browser.equalsIgnoreCase("Firefox")) {
//				desiredCapabilities = DesiredCapabilities.firefox();
//			}
//			if (browser.equalsIgnoreCase("IE")) {
//				desiredCapabilities = DesiredCapabilities.internetExplorer();
//			}
//			if (browser.equalsIgnoreCase("safari")) {
//				desiredCapabilities = DesiredCapabilities.safari();
//			}
//			driver = new RemoteWebDriver(new URL(NODE_URL_WINDOWS_CHROME), desiredCapabilities);
//			dimension = new Dimension(480, 800);
//			driver.manage().window().setSize(dimension);

		} else if (BROWSER_IE.equalsIgnoreCase(driverType)) {
			if (osname.contains(OS_WIN)) {
				File iePath = new File("Drivers/IEDriverServer.exe");
				String path = iePath.getAbsolutePath();
				System.setProperty("webdriver.ie.driver", path);
				return new InternetExplorerDriver();
			} else {
				System.out.println("IE driver cannot start on MAC or linux or unix machines sorry");

			}
		}
		return driver;
	}


}