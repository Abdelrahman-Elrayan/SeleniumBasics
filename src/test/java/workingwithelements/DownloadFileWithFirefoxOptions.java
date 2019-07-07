package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileWithFirefoxOptions {

	WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";
	
	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;

	}

	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.gecko.driver", 
				System.getProperty("user.dir")+"\\resources\\geckodriver.exe");
		driver = new FirefoxDriver(firefoxOption());
		driver.navigate().to("https://the-internet.herokuapp.com/download");
	}
	

	@Test
	public void testDownloadFile() throws InterruptedException {
		driver.findElement(By.linkText("file.txt")).click();
		Thread.sleep(3000);

	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
