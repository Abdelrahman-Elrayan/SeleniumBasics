package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmitMethod {


	ChromeDriver driver;
	WebElement txtSearch;
	
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
	}

	@Test
	public void testSubmit() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		txtSearch = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		System.out.println(txtSearch.getTagName());
		wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
		txtSearch.clear();
		txtSearch.sendKeys("Selenium WebDriver");
		txtSearch.submit();
		txtSearch = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		txtSearch.sendKeys("Selenium WebDriver Book");
		txtSearch.submit();

	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
