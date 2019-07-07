package findingelements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByCssSelector {

	ChromeDriver driver;
	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void findByCssSelector() {

		WebElement usernameTxt = driver.findElement(By.cssSelector("input#username"));
		WebElement passwordTxt = driver.findElement(By.cssSelector("input#password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));
		System.out.println(usernameTxt.getCssValue("background-color"));
		System.out.println(passwordTxt.getCssValue("font-family"));
		System.out.println(loginBtn.getText());
		
	}


	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
