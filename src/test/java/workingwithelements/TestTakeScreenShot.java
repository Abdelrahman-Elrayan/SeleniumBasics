package workingwithelements;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTakeScreenShot {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.amazon.com/");
	}
	
	@Test
	public void testScreenShot() {
		WebElement searchTxt = driver.findElement(By.id("twotabsearchtextbox"));
		searchTxt.sendKeys("Selenium WebDriver Book");
		searchTxt.submit();
		assertTrue(driver.getTitle().contains("Selenium WebDriver"));
	}
	
	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			//Create reference of TakesScreenShots
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("./ScreenShots/"+result.getName()+".png"));
		}
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
