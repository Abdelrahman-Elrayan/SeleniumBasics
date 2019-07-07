package findingelements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {


	ChromeDriver driver;
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		/*driver.manage().window().fullscreen();
		driver.manage().window().fullscreen();*/
		driver.navigate().to("https://the-internet.herokuapp.com/");
	}

	@Test
	public void testCommands() {

		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		
	}


	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
