package workingwithelements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUploadFile {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
	}

	@Test
	public void testUploadFile() throws InterruptedException {
		String imgName = "441886.jpg";
		String imgPath = System.getProperty("user.dir")+"/Uploads/"+imgName;
		
		WebElement fileUploader = driver.findElement(By.id("file-upload"));
		fileUploader.sendKeys(imgPath);
		
		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();
		
		Thread.sleep(3000);
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
		assertEquals(imgName, uploadedFiles.getText());
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
