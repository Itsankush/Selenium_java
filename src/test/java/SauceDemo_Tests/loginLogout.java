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

public class loginLogout {
	WebDriver driver;
	WebDriverWait wait;
	Actions a;
	String passwd;

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

	@AfterTest
	public void log_out() {
		driver.findElement(By.cssSelector("div[class='bm-burger-button'] button")).click();
		WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}

	@Test
	public void log_in() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}
