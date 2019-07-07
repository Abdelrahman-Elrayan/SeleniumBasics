package findingelements;

//import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByElements {


	ChromeDriver driver;
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
	}

	@Test
	public void findByElements() {


		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//assertEquals(actual, expected);
		
		for(WebElement link:links) {
			System.out.println(link.getText()+" : "+link.getAttribute("href"));
		}
	}


	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
