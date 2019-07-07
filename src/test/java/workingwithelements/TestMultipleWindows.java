package workingwithelements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMultipleWindows {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	}
	
	@Test(priority=1)
	public void testWindowUsingTitle() {
		//Store WindowHandle of parent window
		String currentWindowID = driver.getWindowHandle();
		WebElement visitBtn = driver.findElement(By.id("visitbutton"));
		visitBtn.click();


		for(String windowID: driver.getWindowHandles()) {
			String title = driver.switchTo().window(windowID).getTitle();
			
			if(title.equals("Visit Us")) {
				assertEquals("Visit Us", driver.getTitle());
				System.out.println(driver.getTitle());
				driver.close();
				break;
			}
		}
		driver.switchTo().window(currentWindowID);

	}
	
	@Test(priority=2)
	public void testWindowUsingName() {
		String currentWindowID = driver.getWindowHandle();
		WebElement helpBtn = driver.findElement(By.id("helpbutton"));
		helpBtn.click();
		
		driver.switchTo().window("HelpWindow");
		assertEquals("Help", driver.getTitle());
		driver.close();
		driver.switchTo().window(currentWindowID);
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
