package SauceDemo_Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Invalid_credentials {
	WebDriver driver;
	WebDriverWait wait;
	Actions a;
	String passwd;
	String error = "Epic sadface: Username and password do not match any user in this service";

	@BeforeTest
	public void Launch_site() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		a = new Actions(driver);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		// Web site Title verify
		String title = "Swag Labs";
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, title);

		// Get password
		String string1 = driver.findElement(By.className("login_password")).getText();
		String[] str1 = string1.split(":");
		passwd = str1[1];
	}

	@Test
	public void log_in() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user_");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@AfterTest
	public void error() {
		String Act_error = driver
				.findElement(By.xpath("//div[@class='error-message-container error'] //h3[@data-test='error']"))
				.getText();
		Assert.assertEquals(Act_error, error);
	}
}
