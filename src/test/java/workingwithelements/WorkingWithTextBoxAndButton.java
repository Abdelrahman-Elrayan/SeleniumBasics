package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTextBoxAndButton {


	ChromeDriver driver;
	
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void loginScreen() {

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.className("radius"));
		
		
		System.out.println(username.getTagName());
		System.out.println(password.getTagName());
		
		username.clear();
		username.sendKeys("tomsmith");
		
		password.clear();
		password.sendKeys("SuperSecretPassword!");
		
		loginBtn.click();
		
		WebElement successNotification = driver.findElement(By.id("flash"));
		System.out.println(successNotification.getText());
		Assert.assertTrue(successNotification.getText()
				.contains("You logged into a secure area!"));
		
	}


	@AfterTest
	public void closeDriver() {
		driver.quit();
	}


}
