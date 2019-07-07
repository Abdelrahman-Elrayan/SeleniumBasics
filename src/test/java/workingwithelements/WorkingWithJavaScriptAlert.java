package workingwithelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithJavaScriptAlert {

ChromeDriver driver;
	
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	@Test
	public void testAlert() throws InterruptedException {
		WebElement btnAlert = driver.findElement(By.id("simple"));
		btnAlert.click();
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals("Hello! I am an alert box!", alertText);
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
