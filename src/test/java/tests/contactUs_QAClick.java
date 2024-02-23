package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class contactUs_QAClick {
	@Test
	void ContactUs() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@href='contactus.html'])[1]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
		// Wait until "Keep in touch" text is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Keep in touch']")));
		driver.findElement(By.xpath("//input[@placeholder='Your name']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Automation@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Try");
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("1231231230");
		driver.findElement(By.xpath("//textarea[@placeholder='Messege']")).sendKeys("Trying automation");
		// Thread.sleep(4000);
		// driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
}
