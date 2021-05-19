package properties.properties;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class Base extends ReadLocator {

	// Display messages while executing time on console level
	public static Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

	// This variable to limit waiting timeout
	public static final int TIMEOUT = Integer.parseInt(ReadData("TIMEOUT").replaceAll("\\s+", ""));
	public int LONGWAIT = Integer.parseInt(ReadData("LONGWAIT").replaceAll("\\s+", ""));

	// This variable to manage one instance of WebDriver on project level
	public static WebDriver driver = null;

	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	// This method manage WebDriver Start
	// The method Start before all project test cases and all suites
	@BeforeClass
	public static void startBrowser() {
		
		LOGGER.info("Starting Browser... Please wait");

		try {
			 ChromeOptions options = new ChromeOptions();
			    // setting headless mode to true.. so there isn't any ui
			    options.setHeadless(true);

			    
			// To run test cases on Google Chrome
			   
			System.setProperty("webdriver.chrome.driver", "/Users/osama/Downloads/chromedriver");
		    // Create a new instance of the Chrome driver

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();


		} catch (Throwable e) {
			e.printStackTrace(System.out);
			Assert.fail("Please check Browser is exist\nBrowser Unable to start");
		}

		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		if (ReadData("TestType").toLowerCase().equals("admin"))
			driver.navigate().to(ReadData("Admin_URL"));
		else
			driver.navigate().to(ReadData("Site_URL"));


	}

	// This method to take screenshot on Test Fail
	@AfterClass
	public static void takeScreenShotOnFailure() {
		/*
		 * if (testResult.getStatus() == ITestResult.FAILURE) { File scrFile = (File)
		 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(scrFile, new File(ReadData("SCREENSHOT_PATH") +
		 * testResult.getName() + timeStamp + ".png")); }
		 */
		stopBrowser();
	}

	// This method will run after Test Method executed to close Browser
	public static void stopBrowser() {
		try {
			LOGGER.info("Close Browser");
			driver.close();
		} catch (Throwable e) {
			e.getStackTrace();
		}
	}

	// This method will run after all suites executed to close WebDriver
	@AfterSuite
	public static void stopDriver() {
		try {
			LOGGER.info("Shutdown Webdriver");
			driver.quit();
		} catch (Throwable e) {
			e.getStackTrace();
		}
	}

}