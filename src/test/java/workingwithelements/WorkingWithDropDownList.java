package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDropDownList {



	ChromeDriver driver;
	
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
	}
	
	@Test
	public void testDropDownList() throws InterruptedException {
		Select options = new Select (driver.findElement(By.id("dropdown")));
		
		Assert.assertFalse(options.isMultiple());
		
		Assert.assertEquals(3, options.getOptions().size());
		
		//Thread.sleep(2000);
		
		options.selectByVisibleText("Option 2");
		//options.selectByValue("2");
		//options.selectByIndex(1);
		
		Assert.assertEquals("Option 1", options.getFirstSelectedOption().getText());
		Thread.sleep(2000);
	}

	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
