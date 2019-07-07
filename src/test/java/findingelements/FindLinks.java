package findingelements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindLinks {


	ChromeDriver driver;
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void findByLinks() {

		WebElement links = driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(links.getAttribute("href"));
	}
	
	@Test
	public void findByLinksPartial() {

		WebElement links = driver.findElement(By.partialLinkText("Elemental"));
		System.out.println(links.getAttribute("href"));
	}


	@AfterTest
	public void closeDriver() {
		driver.close();
	}


}
