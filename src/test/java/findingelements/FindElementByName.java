package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByName {
	ChromeDriver driver;
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void findElementByName() {

		try {
		
			WebElement username = driver.findElement(By.name("username2"));
			WebElement password = driver.findElement(By.name("password"));

			System.out.println(username.getLocation());
			System.out.println(password.getLocation());

		} catch (NoSuchElementException e) {
			System.out.println(" The Element is not found, Please use another method ");
		}
		
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
