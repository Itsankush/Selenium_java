package tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class blog_QAClick {
	WebDriver driver;
	WebDriverWait wait;
	File src;

	@BeforeMethod
	void Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
	}

	@Test
	void Blog() throws InterruptedException, IOException {
		// Wait until pop up is visible
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@href='https://www.qaclickacademy.com/blog']")));
		driver.findElement(By.xpath("//a[@href='https://www.qaclickacademy.com/blog']")).click();

		// Wait until pop up is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='NO THANKS']")));
		driver.findElement(By.xpath("//button[normalize-space()='NO THANKS']")).click();
		driver.findElement(By.cssSelector("h2[class='title'] a[title='JAVA INTERVIEW QUESTIONS']")).click();
		driver.findElement(By.cssSelector("#comment")).sendKeys("Very usefull");
		driver.findElement(By.cssSelector("#author")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#email")).sendKeys("abc@gmail.com");
		// driver.findElement(By.cssSelector("#submit")).click();
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("target/ScreenShot/ss.jpg")); // Refresh project
	}

	@AfterMethod
	void closeBrowser() {
		driver.close();
	}
}
