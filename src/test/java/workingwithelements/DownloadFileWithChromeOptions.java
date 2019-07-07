package workingwithelements;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileWithChromeOptions {

	public WebDriver driver ; 
	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";

	public static ChromeOptions chromeOption() 
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options ; 		
	}

	@BeforeTest
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver(chromeOption()); 
		driver.navigate().to("http://the-internet.herokuapp.com/download");
	}

	@Test
	public void testDownloadFile() throws InterruptedException 
	{
		driver.findElement(By.linkText("image1.png")).click();
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}


}
