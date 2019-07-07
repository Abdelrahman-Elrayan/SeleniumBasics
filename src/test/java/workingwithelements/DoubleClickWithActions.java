package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithActions {

ChromeDriver driver;
	
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	
	@Test
	public void doubleClickTest() throws InterruptedException {
		
		WebElement message = driver.findElement(By.id("message"));
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
		builder.doubleClick(message).perform();
		Thread.sleep(2000);
		
		Assert.assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));
		
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
	
	
}
