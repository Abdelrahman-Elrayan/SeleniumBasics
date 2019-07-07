package workingwithelements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExplicitWait {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com/");
	}
	
	@Test
	public void testExplicityWait() {
		WebElement queryTxt = driver.findElement(By.className("gLFyf"));
		queryTxt.sendKeys("selenium WebDriver");
		queryTxt.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("selenium"));
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
