package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByXpath {

	ChromeDriver driver;
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void findByXpath() {
		
		/*WebElement usernameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		*/
		
		//- Relative XPath -//
		WebElement usernameTxt = driver.findElement(By.xpath("//input"));
		WebElement passwordTxt = driver.findElement(By.xpath("//input[1]"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@class='radius']"));
		
		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
		System.out.println(loginBtn.getTagName());
	}


	@AfterTest
	public void closeDriver() {
		driver.close();
	}


}
