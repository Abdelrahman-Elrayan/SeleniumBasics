package workingwithelements;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadUsingRobot {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
	}


	@Test
	public void fileUploadWithRobot() throws AWTException, InterruptedException {
		String imgName = "441886.jpg";
		String imgPath = System.getProperty("user.dir")+"\\Uploads\\"+imgName;

		WebElement fileUploader = driver.findElement(By.id("file-upload"));
		fileUploader.click();
		
		//Ctrl + c
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(imgPath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		
		//Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		
		//Ctrl + v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		
		//Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();
		Thread.sleep(3000);
		
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
		Thread.sleep(3000);
		assertEquals(imgName, uploadedFiles.getText());
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
