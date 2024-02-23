package AllType;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Input_Numeric {
	@Test
	public void Task1() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/inputs");
		WebElement input = driver.findElement(By.xpath("//input[@type='number']"));
		input.sendKeys("1a2b3c4d");
		File snap = input.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snap, new File("target/ScreenShot/input_snap.jpg"));
	}
}
